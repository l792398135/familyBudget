package com.ruoyi.payincome.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预算明细对象 family_month_budget_details
 * 
 * @author ruoyi
 * @date 2021-10-19
 */
public class FamilyMonthBudgetDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String dictTypeName;

    /** 类型编码 */
    private String dictType;

    /** 费用编码 */
    private String dictValue;

    /** 费用排序 */
    private Long dictSort;

    /** 预算类型 */
    @Excel(name = "预算类型")
    private String budgetType;

    /** 预算金额 */
    @Excel(name = "预算金额")
    private Long budgetAmount;

    /** 预算周期 */
    @Excel(name = "预算周期")
    private String budgetDate;

    /** 费用名称 */
    @Excel(name = "费用名称")
    private String dictLabel;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDictTypeName(String dictTypeName) 
    {
        this.dictTypeName = dictTypeName;
    }

    public String getDictTypeName() 
    {
        return dictTypeName;
    }
    public void setDictType(String dictType) 
    {
        this.dictType = dictType;
    }

    public String getDictType() 
    {
        return dictType;
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
    public void setBudgetType(String budgetType) 
    {
        this.budgetType = budgetType;
    }

    public String getBudgetType() 
    {
        return budgetType;
    }
    public void setBudgetAmount(Long budgetAmount) 
    {
        this.budgetAmount = budgetAmount;
    }

    public Long getBudgetAmount() 
    {
        return budgetAmount;
    }
    public void setBudgetDate(String budgetDate) 
    {
        this.budgetDate = budgetDate;
    }

    public String getBudgetDate() 
    {
        return budgetDate;
    }
    public void setDictLabel(String dictLabel) 
    {
        this.dictLabel = dictLabel;
    }

    public String getDictLabel() 
    {
        return dictLabel;
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
            .append("dictTypeName", getDictTypeName())
            .append("dictType", getDictType())
            .append("dictValue", getDictValue())
            .append("dictSort", getDictSort())
            .append("budgetType", getBudgetType())
            .append("budgetAmount", getBudgetAmount())
            .append("budgetDate", getBudgetDate())
            .append("dictLabel", getDictLabel())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .toString();
    }
}
