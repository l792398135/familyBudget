package com.ruoyi.search.domain;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单据管理对象 family_bill
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
public class FamilyBill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private List<String> imgUrls;
    /**  */
    private Long id;

    /** 票据名称 */
    @Excel(name = "票据名称")
    private String billName;

    /** 票据金额 */
    @Excel(name = "票据金额")
    private BigDecimal billAmount;

    /** 追加金额 */
    private BigDecimal billAdd;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBillName(String billName) 
    {
        this.billName = billName;
    }

    public String getBillName() 
    {
        return billName;
    }
    public void setBillAmount(BigDecimal billAmount) 
    {
        this.billAmount = billAmount;
    }

    public BigDecimal getBillAmount() 
    {
        return billAmount;
    }
    public void setBillAdd(BigDecimal billAdd) 
    {
        this.billAdd = billAdd;
    }

    public BigDecimal getBillAdd() 
    {
        return billAdd;
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
            .append("billName", getBillName())
            .append("billAmount", getBillAmount())
            .append("billAdd", getBillAdd())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
