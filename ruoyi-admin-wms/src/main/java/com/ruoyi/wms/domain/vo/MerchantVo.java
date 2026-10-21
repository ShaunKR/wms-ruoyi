package com.ruoyi.wms.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.excel.annotation.ExcelDictFormat;
import com.ruoyi.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import com.ruoyi.wms.domain.entity.Merchant;

import java.io.Serial;
import java.io.Serializable;

/**
 * 往来单位视图对象 wms_merchant
 *
 * @author zcc
 * @date 2024-07-16
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Merchant.class)
public class MerchantVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ExcelProperty(value = "id")
    private Long id;

    /**
     * 编号
     */
    @ExcelProperty(value = "코드")
    private String merchantCode;

    /**
     * 名称
     */
    @ExcelProperty(value = "이름")
    private String merchantName;

    /**
     * 企业类型
     */
    @ExcelProperty(value = "거래처 유형", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "merchant_type")
    private Integer merchantType;

    /**
     * 级别
     */
    @ExcelProperty(value = "등급")
    private String merchantLevel;

    /**
     * 联系人
     */
    @ExcelProperty(value = "담당자")
    private String contactPerson;

    /**
     * 备注
     */
    @ExcelProperty(value = "비고")
    private String remark;


}
