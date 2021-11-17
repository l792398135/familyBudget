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
 * 宝贝支出对象 family_child_pay
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
public class FamilyChildPay extends BaseEntity
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

    /** 支出人 */
    @Excel(name = "支出人")
    private String payMenber;

    /** 受益的宝贝 */
    @Excel(name = "受益的宝贝")
    private String benefitChild;

    /** 支出类型 */
    @Excel(name = "支出类型")
    private String payCode;

    /** 支出明细 */
    @Excel(name = "支出明细")
    private String payDetail;

    /** 支出金额 */
    @Excel(name = "支出金额")
    private BigDecimal payAmount;

    /** 支出日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支出日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payDate;

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
    public void setPayMenber(String payMenber) 
    {
        this.payMenber = payMenber;
    }

    public String getPayMenber() 
    {
        return payMenber;
    }
    public void setBenefitChild(String benefitChild) 
    {
        this.benefitChild = benefitChild;
    }

    public String getBenefitChild() 
    {
        return benefitChild;
    }
    public void setPayCode(String payCode) 
    {
        this.payCode = payCode;
    }

    public String getPayCode() 
    {
        return payCode;
    }
    public void setPayDetail(String payDetail) 
    {
        this.payDetail = payDetail;
    }

    public String getPayDetail() 
    {
        return payDetail;
    }
    public void setPayAmount(BigDecimal payAmount) 
    {
        this.payAmount = payAmount;
    }

    public BigDecimal getPayAmount() 
    {
        return payAmount;
    }
    public void setPayDate(Date payDate) 
    {
        this.payDate = payDate;
    }

    public Date getPayDate() 
    {
        return payDate;
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
            .append("payMenber", getPayMenber())
            .append("benefitChild", getBenefitChild())
            .append("payCode", getPayCode())
            .append("payDetail", getPayDetail())
            .append("payAmount", getPayAmount())
            .append("payDate", getPayDate())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
