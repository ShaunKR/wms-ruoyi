package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.wms.domain.entity.Inventory;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 库存业务对象 wms_inventory
 *
 * @author zcc
 * @date 2024-07-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Inventory.class, reverseConvertGenerate = false)
public class InventoryBo extends BaseEntity {

    /**
     *
     */
    @NotNull(message = "항목은 필수입니다.", groups = { EditGroup.class })
    private Long id;

    /**
     * 规格ID
     */
    @NotNull(message = "규격 ID가 필요합니다.", groups = { AddGroup.class, EditGroup.class })
    private Long skuId;

    /**
     * 所属仓库
     */
    @NotNull(message = "창고를 선택해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private Long warehouseId;

    /**
     * 库存
     */
    @NotNull(message = "재고 수량을 입력해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private BigDecimal quantity;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最小数量
     */
    private BigDecimal minQuantity;

    private String itemName;
    private String itemCode;
    private String skuName;
    private String skuCode;
    private Long itemId;
    private Long itemCategory;
}
