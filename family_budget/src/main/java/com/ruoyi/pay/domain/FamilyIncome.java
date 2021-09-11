package com.ruoyi.pay.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 家庭收入对象 family_income
 * 
 * @author 刘兴武
 * @date 2021-09-10
 */
public class FamilyIncome extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 收入成员 */
    @Excel(name = "收入成员")
    private String incomeMenber;

    /** 收入日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收入日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date incomeDate;

    /** 收入金额 */
    @Excel(name = "收入金额")
    private BigDecimal incomeCost;

    /** 收入类型编码 */
    @Excel(name = "收入类型编码")
    private String incomeTypeCode;

    /** 收入明细 */
    @Excel(name = "收入明细")
    private String incomeDetail;

    /** 经办人 */
    @Excel(name = "经办人")
    private String operatorCode;

    /** 记账人 */
    @Excel(name = "记账人")
    private String bookkeeperCode;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setIncomeMenber(String incomeMenber) 
    {
        this.incomeMenber = incomeMenber;
    }

    public String getIncomeMenber() 
    {
        return incomeMenber;
    }
    public void setIncomeDate(Date incomeDate)
    {
        this.incomeDate = incomeDate;
    }

    public Date getIncomeDate()
    {
        return incomeDate;
    }
    public void setIncomeCost(BigDecimal incomeCost) 
    {
        this.incomeCost = incomeCost;
    }

    public BigDecimal getIncomeCost() 
    {
        return incomeCost;
    }
    public void setIncomeTypeCode(String incomeTypeCode) 
    {
        this.incomeTypeCode = incomeTypeCode;
    }

    public String getIncomeTypeCode() 
    {
        return incomeTypeCode;
    }
    public void setIncomeDetail(String incomeDetail) 
    {
        this.incomeDetail = incomeDetail;
    }

    public String getIncomeDetail() 
    {
        return incomeDetail;
    }
    public void setOperatorCode(String operatorCode) 
    {
        this.operatorCode = operatorCode;
    }

    public String getOperatorCode() 
    {
        return operatorCode;
    }
    public void setBookkeeperCode(String bookkeeperCode) 
    {
        this.bookkeeperCode = bookkeeperCode;
    }

    public String getBookkeeperCode() 
    {
        return bookkeeperCode;
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
            .append("incomeMenber", getIncomeMenber())
            .append("incomeDate", getIncomeDate())
            .append("incomeCost", getIncomeCost())
            .append("incomeTypeCode", getIncomeTypeCode())
            .append("incomeDetail", getIncomeDetail())
            .append("operatorCode", getOperatorCode())
            .append("bookkeeperCode", getBookkeeperCode())
            .append("createDate", getCreateDate())
            .toString();
    }
}
