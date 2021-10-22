package com.ruoyi.pay.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 月预算对象 family_month_budget
 * 
 * @author ruoyi
 * @date 2021-09-14
 */
public class FamilyMonthBudget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 预算类型 */
    @Excel(name = "预算类型")
    private String budgetType;

    /** 预算周期 */
    @JsonFormat(pattern = "yyyy-MM")
    @Excel(name = "预算周期", width = 30, dateFormat = "yyyy-MM")
    private Date budgetDate;

    /** 预算费用 */
    @Excel(name = "预算费用")
    private BigDecimal budgetCost;

    private BigDecimal budgetIncome;

    /** 预算备注 */
    @Excel(name = "预算备注")
    private String budgetRemarks;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 创建人员 */
    @Excel(name = "创建人员")
    private String createUser;

    public BigDecimal getBudgetIncome() {
        return budgetIncome;
    }

    public void setBudgetIncome(BigDecimal budgetIncome) {
        this.budgetIncome = budgetIncome;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBudgetType(String budgetType) 
    {
        this.budgetType = budgetType;
    }

    public String getBudgetType() 
    {
        return budgetType;
    }
    public void setBudgetDate(Date budgetDate) 
    {
        this.budgetDate = budgetDate;
    }

    public Date getBudgetDate() 
    {
        return budgetDate;
    }
    public void setBudgetCost(BigDecimal budgetCost) 
    {
        this.budgetCost = budgetCost;
    }

    public BigDecimal getBudgetCost() 
    {
        return budgetCost;
    }
    public void setBudgetRemarks(String budgetRemarks) 
    {
        this.budgetRemarks = budgetRemarks;
    }

    public String getBudgetRemarks() 
    {
        return budgetRemarks;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("budgetType", getBudgetType())
            .append("budgetDate", getBudgetDate())
            .append("budgetCost", getBudgetCost())
            .append("budgetRemarks", getBudgetRemarks())
            .append("createDate", getCreateDate())
            .append("createUser", getCreateUser())
            .toString();
    }
}
