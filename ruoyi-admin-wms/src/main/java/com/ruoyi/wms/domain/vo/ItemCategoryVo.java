package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.ruoyi.common.excel.annotation.ExcelDictFormat;
import com.ruoyi.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import com.ruoyi.wms.domain.entity.ItemCategory;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = ItemCategory.class)
public class ItemCategoryVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 物料类型id
     */
    @ExcelProperty(value = "품목 분류 ID")
    private Long id;

    /**
     * 父物料类型id
     */
    @ExcelProperty(value = "상위 품목 분류 ID")
    private Long parentId;

    /**
     * 祖级列表
     */
    @ExcelProperty(value = "상위 항목 목록")
    private String ancestors;

    /**
     * 物料类型名称
     */
    @ExcelProperty(value = "품목 분류명")
    private String categoryName;

    /**
     * 显示顺序
     */
    @ExcelProperty(value = "표시 순서")
    private Long orderNum;

    /**
     * 物料类型状态（0正常 1停用）
     */
    @ExcelProperty(value = "품목 분류 상태", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "0=정상,1=사용 중지")
    private String status;

    /**
     * 子物料类型
     */
    @TableField(exist = false)
    private List<ItemCategoryVo> children = new ArrayList<ItemCategoryVo>();

}
