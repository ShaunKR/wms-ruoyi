package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.wms.domain.entity.Merchant;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 往来单位业务对象 wms_merchant
 *
 * @author zcc
 * @date 2024-07-16
 */

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Merchant.class, reverseConvertGenerate = false)
public class MerchantBo extends BaseEntity {

    /**
     * id
     */
    @NotNull(message = "ID가 필요합니다.", groups = { EditGroup.class })
    private Long id;

    /**
     * 编号
     */
    @NotBlank(message = "코드를 입력해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private String merchantCode;

    /**
     * 名称
     */
    @NotBlank(message = "이름을 입력해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private String merchantName;

    /**
     * 企业类型
     */
    @NotNull(message = "거래처 유형을 선택해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private Integer merchantType;

    /**
     * 级别
     */
    private String merchantLevel;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 银行账户
     */
    private String bankAccount;

    /**
     * 地址
     */
    private String address;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 座机号
     */
    private String tel;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * Email
     */
    private String email;

    /**
     * 备注
     */
    private String remark;


}
