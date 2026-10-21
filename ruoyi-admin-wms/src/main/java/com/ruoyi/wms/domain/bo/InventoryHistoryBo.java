package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseHistoryEntity;
import com.ruoyi.wms.domain.entity.InventoryHistory;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 库存记录业务对象 wms_inventory_history
 *
 * @author zcc
 * @date 2024-07-22
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = InventoryHistory.class, reverseConvertGenerate = false)
public class InventoryHistoryBo extends BaseHistoryEntity {

    /**
     *
     */
    @NotNull(message = "항목은 필수입니다.", groups = { EditGroup.class })
    private Long id;

    /**
     * 操作id（出库、入库、库存移动表单id）
     */
    @NotNull(message = "처리 전표 ID가 필요합니다.", groups = { AddGroup.class, EditGroup.class })
    private Long orderId;

    /**
     * 操作单号（入库、出库、移库、盘库单号）
     */
    @NotNull(message = "처리 전표 번호를 입력해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private String orderNo;

    /**
     * 订单类型
     */
    @NotNull(message = "전표 유형을 선택해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private Integer orderType;

    /**
     * 物料ID
     */
    @NotNull(message = "품목 ID가 필요합니다.", groups = { AddGroup.class, EditGroup.class })
    private Long skuId;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 库存变化
     */
    @NotNull(message = "재고 변경 수량을 입력해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal quantity;

    /**
     * 备注
     */
    @NotBlank(message = "비고를 입력해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private String remark;

    /**
     * 所属仓库
     */
    @NotNull(message = "창고를 선택해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private Long warehouseId;

    private String itemName;
    private String itemCode;
    private String skuName;
    private String skuCode;

    private String startTime;
    private String endTime;

}
