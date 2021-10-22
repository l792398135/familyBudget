package com.ruoyi.finance.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 负债对象 family_loan
 * 
 * @author ruoyi
 * @date 2021-09-28
 */
public class FamilyLoan extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private List<String> imgUrls;

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }
    /**  */
    private Long id;

    /** 贷款人 */
    @Excel(name = "贷款人")
    private String loanMenber;

    /** 贷款金额 */
    @Excel(name = "贷款金额")
    private BigDecimal loanAmount;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loanStartDate;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loanEndDate;

    /** 利率 */
    @Excel(name = "利率")
    private BigDecimal loanRate;

    /** 平台 */
    @Excel(name = "平台")
    private String loanPlatform;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLoanMenber(String loanMenber) 
    {
        this.loanMenber = loanMenber;
    }

    public String getLoanMenber() 
    {
        return loanMenber;
    }
    public void setLoanAmount(BigDecimal loanAmount) 
    {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getLoanAmount() 
    {
        return loanAmount;
    }
    public void setLoanStartDate(Date loanStartDate) 
    {
        this.loanStartDate = loanStartDate;
    }

    public Date getLoanStartDate() 
    {
        return loanStartDate;
    }
    public void setLoanEndDate(Date loanEndDate) 
    {
        this.loanEndDate = loanEndDate;
    }

    public Date getLoanEndDate() 
    {
        return loanEndDate;
    }
    public void setLoanRate(BigDecimal loanRate) 
    {
        this.loanRate = loanRate;
    }

    public BigDecimal getLoanRate() 
    {
        return loanRate;
    }
    public void setLoanPlatform(String loanPlatform) 
    {
        this.loanPlatform = loanPlatform;
    }

    public String getLoanPlatform() 
    {
        return loanPlatform;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("loanMenber", getLoanMenber())
            .append("loanAmount", getLoanAmount())
            .append("loanStartDate", getLoanStartDate())
            .append("loanEndDate", getLoanEndDate())
            .append("loanRate", getLoanRate())
            .append("loanPlatform", getLoanPlatform())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
