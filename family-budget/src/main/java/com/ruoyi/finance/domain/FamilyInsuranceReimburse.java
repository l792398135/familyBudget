package com.ruoyi.finance.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 保险报销对象 family_insurance_reimburse
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
public class FamilyInsuranceReimburse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 报销人 */
    @Excel(name = "报销人")
    private String reimburseMenber;

    /** 报销类型 */
    @Excel(name = "报销类型")
    private String reimburseType;

    /** 报销明细 */
    @Excel(name = "报销明细")
    private String reimburseDetails;

    /** 报销金额 */
    @Excel(name = "报销金额")
    private BigDecimal reimburseAmount;

    /** 报销日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报销日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reimburseDate;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setReimburseMenber(String reimburseMenber) 
    {
        this.reimburseMenber = reimburseMenber;
    }

    public String getReimburseMenber() 
    {
        return reimburseMenber;
    }
    public void setReimburseType(String reimburseType) 
    {
        this.reimburseType = reimburseType;
    }

    public String getReimburseType() 
    {
        return reimburseType;
    }
    public void setReimburseDetails(String reimburseDetails) 
    {
        this.reimburseDetails = reimburseDetails;
    }

    public String getReimburseDetails() 
    {
        return reimburseDetails;
    }
    public void setReimburseAmount(BigDecimal reimburseAmount) 
    {
        this.reimburseAmount = reimburseAmount;
    }

    public BigDecimal getReimburseAmount() 
    {
        return reimburseAmount;
    }
    public void setReimburseDate(Date reimburseDate) 
    {
        this.reimburseDate = reimburseDate;
    }

    public Date getReimburseDate() 
    {
        return reimburseDate;
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
            .append("reimburseMenber", getReimburseMenber())
            .append("reimburseType", getReimburseType())
            .append("reimburseDetails", getReimburseDetails())
            .append("reimburseAmount", getReimburseAmount())
            .append("reimburseDate", getReimburseDate())
            .append("remark", getRemark())
            .append("createUser", getCreateUser())
            .append("createDate", getCreateDate())
            .toString();
    }
}
