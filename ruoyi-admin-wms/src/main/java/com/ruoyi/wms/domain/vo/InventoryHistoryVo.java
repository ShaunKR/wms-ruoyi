package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.excel.annotation.ExcelDictFormat;
import com.ruoyi.common.excel.convert.ExcelDictConvert;
import com.ruoyi.wms.domain.entity.InventoryHistory;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 库存记录视图对象 wms_inventory_history
 *
 * @author zcc
 * @date 2024-07-22
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = InventoryHistory.class)
public class InventoryHistoryVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 操作id（出库、入库、库存移动表单id）
     */
    @ExcelProperty(value = "작업id", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "입출고·이동 전표 ID")
    private Long orderId;

    /**
     * 操作单号（入库、出库、移库、盘库单号）
     */
    @ExcelProperty(value = "처리 전표 번호")
    private String orderNo;

    /**
     * 订单类型
     */
    @ExcelProperty(value = "전표 유형")
    private Integer orderType;

    /**
     * 物料ID
     */
    @ExcelProperty(value = "품목 ID")
    private Long skuId;

    /**
     * 金额
     */
    @ExcelProperty(value = "금액")
    private BigDecimal amount;

    /**
     * 库存变化
     */
    @ExcelProperty(value = "재고 변경")
    private BigDecimal quantity;

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

    /**
     * 更新前数量
     */
    private BigDecimal beforeQuantity;
    /**
     * 更新后数量
     */
    private BigDecimal afterQuantity;

    private ItemSkuVo itemSku;

    private ItemVo item;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
