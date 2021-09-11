package com.ruoyi.budget.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预算对象 family_budget
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
public class FamilyBudget extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成员编码 */
    @Excel(name = "成员编码")
    private String familyMemberCode;

    /** 费用编码 */
    @Excel(name = "费用编码")
    private String feeTypeCode;

    /** 预算费用 */
    @Excel(name = "预算费用")
    private String budgetCost;

    /** 预算日期 */
    @Excel(name = "预算日期")
    private String dateCode;

    public void setFamilyMemberCode(String familyMemberCode) 
    {
        this.familyMemberCode = familyMemberCode;
    }

    public String getFamilyMemberCode() 
    {
        return familyMemberCode;
    }
    public void setFeeTypeCode(String feeTypeCode) 
    {
        this.feeTypeCode = feeTypeCode;
    }

    public String getFeeTypeCode() 
    {
        return feeTypeCode;
    }
    public void setBudgetCost(String budgetCost) 
    {
        this.budgetCost = budgetCost;
    }

    public String getBudgetCost() 
    {
        return budgetCost;
    }
    public void setDateCode(String dateCode) 
    {
        this.dateCode = dateCode;
    }

    public String getDateCode() 
    {
        return dateCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("familyMemberCode", getFamilyMemberCode())
            .append("feeTypeCode", getFeeTypeCode())
            .append("budgetCost", getBudgetCost())
            .append("dateCode", getDateCode())
            .toString();
    }
}
