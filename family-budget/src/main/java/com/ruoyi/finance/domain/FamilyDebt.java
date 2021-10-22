package com.ruoyi.finance.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 债务对象 family_debt
 * 
 * @author ruoyi
 * @date 2021-09-25
 */
public class FamilyDebt extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 借出人 */
    @Excel(name = "借出人")
    private String debtMember;

    /** 借出金额 */
    @Excel(name = "借出金额")
    private BigDecimal debtAmount;

    /** 借出日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "借出日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date debtDate;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 利率 */
    @Excel(name = "利率")
    private BigDecimal debtRate;

    /** 借钱人 */
    @Excel(name = "借钱人")
    private String borrowMember;

    /** 借钱人电话 */
    @Excel(name = "借钱人电话")
    private String borrowTel;

    /** 借钱人身份证 */
    @Excel(name = "借钱人身份证")
    private String borrowIdcard;

    /** 借钱人备注 */
    @Excel(name = "借钱人备注")
    private String brorrowRemark;

    /** 预计收益 */
    @Excel(name = "预计收益")
    private BigDecimal income;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /**  */
    @Excel(name = "")
    private String createUser;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDebtMember(String debtMember) 
    {
        this.debtMember = debtMember;
    }

    public String getDebtMember() 
    {
        return debtMember;
    }
    public void setDebtAmount(BigDecimal debtAmount) 
    {
        this.debtAmount = debtAmount;
    }

    public BigDecimal getDebtAmount() 
    {
        return debtAmount;
    }
    public void setDebtDate(Date debtDate) 
    {
        this.debtDate = debtDate;
    }

    public Date getDebtDate() 
    {
        return debtDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setDebtRate(BigDecimal debtRate) 
    {
        this.debtRate = debtRate;
    }

    public BigDecimal getDebtRate() 
    {
        return debtRate;
    }
    public void setBorrowMember(String borrowMember) 
    {
        this.borrowMember = borrowMember;
    }

    public String getBorrowMember() 
    {
        return borrowMember;
    }
    public void setBorrowTel(String borrowTel) 
    {
        this.borrowTel = borrowTel;
    }

    public String getBorrowTel() 
    {
        return borrowTel;
    }
    public void setBorrowIdcard(String borrowIdcard) 
    {
        this.borrowIdcard = borrowIdcard;
    }

    public String getBorrowIdcard() 
    {
        return borrowIdcard;
    }
    public void setBrorrowRemark(String brorrowRemark) 
    {
        this.brorrowRemark = brorrowRemark;
    }

    public String getBrorrowRemark() 
    {
        return brorrowRemark;
    }
    public void setIncome(BigDecimal income) 
    {
        this.income = income;
    }

    public BigDecimal getIncome() 
    {
        return income;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("debtMember", getDebtMember())
            .append("debtAmount", getDebtAmount())
            .append("debtDate", getDebtDate())
            .append("endDate", getEndDate())
            .append("debtRate", getDebtRate())
            .append("borrowMember", getBorrowMember())
            .append("borrowTel", getBorrowTel())
            .append("borrowIdcard", getBorrowIdcard())
            .append("brorrowRemark", getBrorrowRemark())
            .append("income", getIncome())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .toString();
    }
}
