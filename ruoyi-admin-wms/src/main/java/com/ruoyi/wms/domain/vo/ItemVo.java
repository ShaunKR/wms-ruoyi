package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.wms.domain.entity.Item;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Item.class)
public class ItemVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ExcelProperty(value = "")
    private Long id;

    /**
     * 编号
     */
    @ExcelProperty(value = "코드")
    private String itemCode;

    /**
     * 名称
     */
    @ExcelProperty(value = "이름")
    private String itemName;

    /**
     * 分类
     */
    @ExcelProperty(value = "분류")
    private String itemCategory;

    /**
     * 单位类别
     */
    @ExcelProperty(value = "단위")
    private String unit;

    /**
     * 品牌
     */
    @ExcelProperty(value = "브랜드")
    private Long itemBrand;

    /**
     * 备注
     */
    @ExcelProperty(value = "비고")
    private String remark;

    /**
     * 类别
     */
    private ItemCategoryVo itemCategoryInfo;
}
