package com.ruoyi.child.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资金代管对象 family_child_fund_agent
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
public class FamilyChildFundAgent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long businessId;
    /**  */
    private Long id;

    /** 出资人 */
    @Excel(name = "出资人")
    private String costMenber;

    /** 代理人 */
    @Excel(name = "代理人")
    private String moneyAgent;

    /** 归属的宝贝 */
    @Excel(name = "归属的宝贝")
    private String childCode;

    /** 资金金额 */
    @Excel(name = "资金金额")
    private BigDecimal fundAmount;

    /** 代理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "代理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date agentDate;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCostMenber(String costMenber) 
    {
        this.costMenber = costMenber;
    }

    public String getCostMenber() 
    {
        return costMenber;
    }
    public void setMoneyAgent(String moneyAgent) 
    {
        this.moneyAgent = moneyAgent;
    }

    public String getMoneyAgent() 
    {
        return moneyAgent;
    }
    public void setChildCode(String childCode) 
    {
        this.childCode = childCode;
    }

    public String getChildCode() 
    {
        return childCode;
    }
    public void setFundAmount(BigDecimal fundAmount) 
    {
        this.fundAmount = fundAmount;
    }

    public BigDecimal getFundAmount() 
    {
        return fundAmount;
    }
    public void setAgentDate(Date agentDate) 
    {
        this.agentDate = agentDate;
    }

    public Date getAgentDate() 
    {
        return agentDate;
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
            .append("costMenber", getCostMenber())
            .append("moneyAgent", getMoneyAgent())
            .append("childCode", getChildCode())
            .append("fundAmount", getFundAmount())
            .append("agentDate", getAgentDate())
            .append("remark", getRemark())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
