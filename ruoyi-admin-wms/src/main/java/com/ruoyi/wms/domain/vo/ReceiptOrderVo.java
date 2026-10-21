package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.wms.domain.entity.ReceiptOrder;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 入库单视图对象 wms_receipt_order
 *
 * @author zcc
 * @date 2024-07-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
@AutoMapper(target = ReceiptOrder.class)
public class ReceiptOrderVo extends BaseOrderVo<ReceiptOrderDetailVo> {

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
