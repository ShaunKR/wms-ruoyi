package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.wms.domain.entity.Inventory;
import com.ruoyi.wms.domain.entity.MovementOrderDetail;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 库存移动详情业务对象 wms_movement_order_detail
 *
 * @author zcc
 * @date 2024-08-09
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMappers({
    @AutoMapper(target = MovementOrderDetail.class, reverseConvertGenerate = false),
    @AutoMapper(target = Inventory.class, reverseConvertGenerate = false)
})
public class MovementOrderDetailBo extends BaseOrderDetailBo {

    /**
     * 源仓库
     */
    @NotNull(message = "출발 창고를 선택해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private Long sourceWarehouseId;

    /**
     * 目标仓库
     */
    @NotNull(message = "도착 창고를 선택해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private Long targetWarehouseId;

}
