package com.ruoyi.payincome.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 转账对象 family_transfer_account
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
public class FamilyTransferAccount extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private String businessType;

    private Long businessId;
    /**  */
    private Long id;

    /** 转账金额 */
    @Excel(name = "转账金额")
    private BigDecimal transferAccount;

    /** 转账人 */
    @Excel(name = "转账人")
    private String transfer;

    /** 接受人 */
    @Excel(name = "接受人")
    private String accepter;

    /** 转账时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "转账时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transferTime;

    /**  */
    @Excel(name = "")
    private String createUser;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

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
    public void setTransferAccount(BigDecimal transferAccount) 
    {
        this.transferAccount = transferAccount;
    }

    public BigDecimal getTransferAccount() 
    {
        return transferAccount;
    }
    public void setTransfer(String transfer) 
    {
        this.transfer = transfer;
    }

    public String getTransfer() 
    {
        return transfer;
    }
    public void setAccepter(String accepter) 
    {
        this.accepter = accepter;
    }

    public String getAccepter() 
    {
        return accepter;
    }
    public void setTransferTime(Date transferTime) 
    {
        this.transferTime = transferTime;
    }

    public Date getTransferTime() 
    {
        return transferTime;
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
            .append("transferAccount", getTransferAccount())
            .append("transfer", getTransfer())
            .append("accepter", getAccepter())
            .append("remark", getRemark())
            .append("transferTime", getTransferTime())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
