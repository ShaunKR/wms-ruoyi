package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.wms.domain.entity.ShipmentOrder;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 出库单视图对象 wms_shipment_order
 *
 * @author zcc
 * @date 2024-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@AutoMapper(target = ShipmentOrder.class)
public class ShipmentOrderVo extends BaseOrderVo<ShipmentOrderDetailVo>{

    /**
     * 入库类型
     */
    @ExcelProperty(value = "처리 유형")
    private Long optType;

    /**
     * 供应商
     */
    @ExcelProperty(value = "거래처 ID")
    private Long merchantId;

    /**
     * 订单号
     */
    @ExcelProperty(value = "업무 주문 번호")
    private String bizOrderNo;
}
