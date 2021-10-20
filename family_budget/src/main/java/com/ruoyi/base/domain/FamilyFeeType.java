package com.ruoyi.base.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 费用类型对象 family_fee_type
 * 
 * @author ruoyi
 * @date 2021-10-19
 */
public class FamilyFeeType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 类型编码 */
    @Excel(name = "类型编码")
    private String dictType;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String dictTypeName;

    /** 费用编码 */
    @Excel(name = "费用编码")
    private String dictValue;

    /** 费用排序 */
    @Excel(name = "费用排序")
    private Long dictSort;

    /** 费用名称 */
    @Excel(name = "费用名称")
    private String dictLabel;

    /** 是否控制 1控制 0 不控制 */
    @Excel(name = "是否控制 1控制 0 不控制")
    private String controlFlag;

    /** 创建人 */
    private String createUser;

    /** 创建时间 */
    private Date createDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDictType(String dictType) 
    {
        this.dictType = dictType;
    }

    public String getDictType() 
    {
        return dictType;
    }
    public void setDictTypeName(String dictTypeName) 
    {
        this.dictTypeName = dictTypeName;
    }

    public String getDictTypeName() 
    {
        return dictTypeName;
    }
    public void setDictValue(String dictValue) 
    {
        this.dictValue = dictValue;
    }

    public String getDictValue() 
    {
        return dictValue;
    }
    public void setDictSort(Long dictSort) 
    {
        this.dictSort = dictSort;
    }

    public Long getDictSort() 
    {
        return dictSort;
    }
    public void setDictLabel(String dictLabel) 
    {
        this.dictLabel = dictLabel;
    }

    public String getDictLabel() 
    {
        return dictLabel;
    }
    public void setControlFlag(String controlFlag) 
    {
        this.controlFlag = controlFlag;
    }

    public String getControlFlag() 
    {
        return controlFlag;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dictType", getDictType())
            .append("dictTypeName", getDictTypeName())
            .append("dictValue", getDictValue())
            .append("dictSort", getDictSort())
            .append("dictLabel", getDictLabel())
            .append("controlFlag", getControlFlag())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .toString();
    }
}
