package com.ruoyi.wms.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.wms.domain.entity.Item;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Item.class, reverseConvertGenerate = false)
public class ItemBo extends BaseEntity {

    /**
     *
     */
    @NotNull(message = "항목은 필수입니다.", groups = { EditGroup.class })
    private Long id;

    /**
     * 主键集合
     */
    private List<Long> ids;

    /**
     * 编号
     */
    private String itemCode;

    /**
     * 名称
     */
    @NotBlank(message = "이름을 입력해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private String itemName;

    /**
     * 分类
     */
    @NotBlank(message = "분류를 선택해 주세요.", groups = { AddGroup.class, EditGroup.class })
    private String itemCategory;

    /**
     * 单位类别
     */
    private String unit;

    /**
     * 品牌
     */
    private Long itemBrand;


    /**
     * 备注
     */
    private String remark;

    private List<ItemSkuBo> sku;

}
