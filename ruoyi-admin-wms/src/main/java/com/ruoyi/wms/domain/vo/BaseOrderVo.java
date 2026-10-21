package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.mybatis.core.domain.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ExcelIgnoreUnannotated
public class BaseOrderVo<T extends BaseOrderDetailVo> extends BaseVo {
    /**
     *
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 入库单号
     */
    @ExcelProperty(value = "전표 번호")
    private String orderNo;

    /**
     * 商品总数
     */
    @ExcelProperty(value = "상품 총수량")
    private BigDecimal totalQuantity;

    /**
     * 订单金额
     */
    @ExcelProperty(value = "전표 총금액")
    private BigDecimal totalAmount;

    /**
     * 入库状态
     */
    @ExcelProperty(value = "전표 상태")
    private Integer orderStatus;

    /**
     * 仓库id
     */
    @ExcelProperty(value = "창고 ID")
    private Long warehouseId;

    /**
     * 备注
     */
    @ExcelProperty(value = "비고")
    private String remark;

    private List<T> details;
}
