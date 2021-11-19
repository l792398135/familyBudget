package com.ruoyi.payincome.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 费用支出对象 family_pay
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
public class FamilyPay extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private String businessType;

    private Long businessId;
    /**  */
    private Long id;

    /** 支出成员 */
    @Excel(name = "支出成员")
    private String payMenber;

    /** 支出日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支出日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payDate;

    /** 支出金额 */
    @Excel(name = "支出金额")
    private BigDecimal payCost;

    /** 支出类型 */
    @Excel(name = "支出类型")
    private String payTypeCode;

    /** 支出明细 */
    @Excel(name = "支出明细")
    private String payDetail;

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

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

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
    public void setPayDate(Date payDate) 
    {
        this.payDate = payDate;
    }

    public Date getPayDate() 
    {
        return payDate;
    }
    public void setPayCost(BigDecimal payCost)
    {
        this.payCost = payCost;
    }

    public BigDecimal getPayCost()
    {
        return payCost;
    }
    public void setPayTypeCode(String payTypeCode) 
    {
        this.payTypeCode = payTypeCode;
    }

    public String getPayTypeCode() 
    {
        return payTypeCode;
    }
    public void setPayDetail(String payDetail) 
    {
        this.payDetail = payDetail;
    }

    public String getPayDetail() 
    {
        return payDetail;
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
            .append("payMenber", getPayMenber())
            .append("payDate", getPayDate())
            .append("payCost", getPayCost())
            .append("payTypeCode", getPayTypeCode())
            .append("payDetail", getPayDetail())
            .append("operatorCode", getOperatorCode())
            .append("bookkeeperCode", getBookkeeperCode())
            .append("createDate", getCreateDate())
            .toString();
    }
}
