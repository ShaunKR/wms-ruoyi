package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.wms.domain.entity.ReceiptOrder;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 入库单业务对象 wms_receipt_order
 *
 * @author zcc
 * @date 2024-07-19
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = ReceiptOrder.class, reverseConvertGenerate = false)
public class ReceiptOrderBo extends BaseOrderBo<ReceiptOrderDetailBo> {

    /**
     * 入库类型
     */
    @NotNull(message = "입고 유형을 선택해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private Long optType;

    /**
     * 订单号
     */
    private String bizOrderNo;
    /**
     * 对接商户
     */
    private Long merchantId;
    /**
     * 仓库id
     */
    @NotNull(message = "창고항목은 필수입니다.", groups = { AddGroup.class, EditGroup.class })
    private Long warehouseId;

}
