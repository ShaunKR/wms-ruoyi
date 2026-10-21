package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseOrderBo<T extends BaseOrderDetailBo> extends BaseEntity {
    /**
     *
     */
    @NotNull(message = "항목은 필수입니다.", groups = { EditGroup.class })
    private Long id;

    /**
     * 业务单号
     */
    @NotBlank(message = "입고 전표 번호를 입력해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private String orderNo;

    /**
     * 商品总数
     */
    private BigDecimal totalQuantity;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 商品信息
     */
    private List<T> details;
}
