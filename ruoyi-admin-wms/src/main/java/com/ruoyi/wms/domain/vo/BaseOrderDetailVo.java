package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ExcelIgnoreUnannotated
public class BaseOrderDetailVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 入库单号
     */
    @ExcelProperty(value = "전표 번호")
    private Long orderId;

    /**
     * 规格id
     */
    @ExcelProperty(value = "규격 ID")
    private Long skuId;

    /**
     * 入库数量
     */
    @ExcelProperty(value = "수량")
    private BigDecimal quantity;

    /**
     * 金额
     */
    @ExcelProperty(value = "금액")
    private BigDecimal amount;

    /**
     * 备注
     */
    @ExcelProperty(value = "비고")
    private String remark;

    /**
     * 所属仓库
     */
    @ExcelProperty(value = "소속 창고")
    private Long warehouseId;

    private ItemSkuVo itemSku;

    private ItemVo item;
}
