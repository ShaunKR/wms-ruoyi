package com.ruoyi.wms.service;

import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.wms.domain.bo.BaseOrderDetailBo;
import com.ruoyi.wms.domain.entity.Inventory;
import com.ruoyi.wms.mapper.InventoryMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/** Service boundary tests: reject invalid quantities before any database operation. */
@Tag("dev")
class InventoryQuantityTest {
    private InventoryMapper mapper;
    private InventoryService service;

    @BeforeEach
    void setUp() {
        mapper = mock(InventoryMapper.class);
        service = spy(new InventoryService(mapper, mock(ItemSkuService.class)));
        Inventory inventory = new Inventory();
        inventory.setQuantity(new BigDecimal("10"));
        when(mapper.selectOne(any())).thenReturn(inventory);
        doReturn(true).when(service).updateBatchById(anyCollection());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"0", "-3"})
    void invalidReceiptDoesNotTouchDatabase(String quantity) {
        assertThrows(ServiceException.class, () -> service.add(List.of(detail(quantity))));
        verifyNoInteractions(mapper);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"0", "-3"})
    void invalidShipmentDoesNotTouchDatabase(String quantity) {
        assertThrows(ServiceException.class, () -> service.subtract(List.of(detail(quantity))));
        verifyNoInteractions(mapper);
    }

    @Test
    void rejectsWholeRequestBeforeProcessingEarlierValidLine() {
        assertThrows(ServiceException.class,
            () -> service.subtract(List.of(detail("2"), detail("-3"))));
        verifyNoInteractions(mapper);
    }

    @Test
    void positiveFractionalShipmentPreservesBeforeAndAfterQuantities() {
        Inventory inventory = new Inventory();
        inventory.setQuantity(new BigDecimal("10"));
        when(mapper.selectOne(any())).thenReturn(inventory);
        doReturn(true).when(service).updateBatchById(anyCollection());
        BaseOrderDetailBo detail = detail("2.5");
        service.subtract(List.of(detail));
        assertEquals(0, new BigDecimal("10").compareTo(detail.getBeforeQuantity()));
        assertEquals(0, new BigDecimal("7.5").compareTo(detail.getAfterQuantity()));
        assertEquals(0, new BigDecimal("7.5").compareTo(inventory.getQuantity()));
    }

    private BaseOrderDetailBo detail(String quantity) {
        BaseOrderDetailBo detail = new BaseOrderDetailBo();
        detail.setWarehouseId(1L);
        detail.setSkuId(1L);
        detail.setQuantity(quantity == null ? null : new BigDecimal(quantity));
        return detail;
    }
}
