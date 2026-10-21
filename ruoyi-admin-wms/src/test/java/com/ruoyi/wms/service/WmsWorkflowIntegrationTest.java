package com.ruoyi.wms.service;

import com.ruoyi.common.core.constant.ServiceConstants;
import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.wms.domain.bo.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/** Opt-in MySQL test; uses a unique warehouse and removes only its own fixtures. */
@Tag("dev")
@EnabledIfEnvironmentVariable(named = "WMS_DB_TEST", matches = "1")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
class WmsWorkflowIntegrationTest {
    @Autowired JdbcTemplate jdbc;
    @Autowired ReceiptOrderService receipts;
    @Autowired ShipmentOrderService shipments;
    long warehouse;
    long sku;
    String prefix;

    @BeforeEach
    void setUp() {
        assertEquals("wms_portfolio", jdbc.queryForObject("SELECT DATABASE()", String.class));
        prefix = "PF-" + UUID.randomUUID().toString().substring(0, 8);
        warehouse = Math.abs(UUID.randomUUID().getMostSignificantBits() % 1000000000) + 8000000000L;
        sku = jdbc.queryForObject("SELECT MIN(id) FROM wms_item_sku", Long.class);
        jdbc.update("INSERT INTO wms_warehouse(id, warehouse_name) VALUES (?, ?)", warehouse, prefix);
    }

    @AfterEach
    void cleanUp() {
        if (prefix == null) return;
        jdbc.update("DELETE d FROM wms_receipt_order_detail d JOIN wms_receipt_order o ON o.id=d.order_id WHERE o.order_no LIKE ?", prefix + "%");
        jdbc.update("DELETE d FROM wms_shipment_order_detail d JOIN wms_shipment_order o ON o.id=d.order_id WHERE o.order_no LIKE ?", prefix + "%");
        jdbc.update("DELETE FROM wms_inventory_history WHERE warehouse_id=?", warehouse);
        jdbc.update("DELETE FROM wms_receipt_order WHERE order_no LIKE ?", prefix + "%");
        jdbc.update("DELETE FROM wms_shipment_order WHERE order_no LIKE ?", prefix + "%");
        jdbc.update("DELETE FROM wms_inventory WHERE warehouse_id=?", warehouse);
        jdbc.update("DELETE FROM wms_warehouse WHERE id=?", warehouse);
    }

    @Test
    void receive100Ship30Leaves70AndTwoHistoryRows() {
        receipts.receive(receipt("100"));
        shipments.shipment(shipment("30"));
        assertQuantity("70");
        assertEquals(2, jdbc.queryForObject("SELECT COUNT(*) FROM wms_inventory_history WHERE warehouse_id=?", Integer.class, warehouse));
        BigDecimal net = jdbc.queryForObject("SELECT SUM(quantity) FROM wms_inventory_history WHERE warehouse_id=?", BigDecimal.class, warehouse);
        assertEquals(0, new BigDecimal("70").compareTo(net));
    }

    @Test
    void insufficientShipmentRollsBackOrderDetailsAndHistory() {
        receipts.receive(receipt("10"));
        ShipmentOrderBo order = shipment("11");
        assertThrows(ServiceException.class, () -> shipments.shipment(order));
        assertQuantity("10");
        assertEquals(0, jdbc.queryForObject("SELECT COUNT(*) FROM wms_shipment_order WHERE order_no=?", Integer.class, order.getOrderNo()));
        assertEquals(0, jdbc.queryForObject("SELECT COUNT(*) FROM wms_shipment_order_detail WHERE order_id=?", Integer.class, order.getId()));
        assertEquals(1, jdbc.queryForObject("SELECT COUNT(*) FROM wms_inventory_history WHERE warehouse_id=?", Integer.class, warehouse));
    }

    @Test
    void negativeShipmentRollsBackOrderAndPreservesInventory() {
        receipts.receive(receipt("10"));
        ShipmentOrderBo order = shipment("-3");
        assertThrows(ServiceException.class, () -> shipments.shipment(order));
        assertQuantity("10");
        assertEquals(0, jdbc.queryForObject("SELECT COUNT(*) FROM wms_shipment_order WHERE order_no=?", Integer.class, order.getOrderNo()));
        assertEquals(1, jdbc.queryForObject("SELECT COUNT(*) FROM wms_inventory_history WHERE warehouse_id=?", Integer.class, warehouse));
    }

    private ReceiptOrderBo receipt(String quantity) {
        ReceiptOrderBo order = new ReceiptOrderBo();
        order.setOrderNo(prefix + "-R");
        order.setWarehouseId(warehouse);
        order.setOptType(1L);
        order.setOrderStatus(ServiceConstants.ReceiptOrderStatus.FINISH);
        ReceiptOrderDetailBo detail = new ReceiptOrderDetailBo();
        fill(detail, quantity);
        order.setDetails(List.of(detail));
        return order;
    }

    private ShipmentOrderBo shipment(String quantity) {
        ShipmentOrderBo order = new ShipmentOrderBo();
        order.setOrderNo(prefix + "-S");
        order.setWarehouseId(warehouse);
        order.setOptType(1L);
        order.setOrderStatus(ServiceConstants.ShipmentOrderStatus.FINISH);
        ShipmentOrderDetailBo detail = new ShipmentOrderDetailBo();
        fill(detail, quantity);
        order.setDetails(List.of(detail));
        return order;
    }

    private void fill(BaseOrderDetailBo detail, String quantity) {
        detail.setWarehouseId(warehouse);
        detail.setSkuId(sku);
        detail.setQuantity(new BigDecimal(quantity));
    }

    private void assertQuantity(String expected) {
        BigDecimal actual = jdbc.queryForObject("SELECT quantity FROM wms_inventory WHERE warehouse_id=? AND sku_id=?", BigDecimal.class, warehouse, sku);
        assertEquals(0, new BigDecimal(expected).compareTo(actual));
    }
}
