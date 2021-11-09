package com.ruoyi.fixedasset.domain;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 盘点详情对象 family_check_details
 * 
 * @author ruoyi
 * @date 2021-09-23
 */
public class FamilyCheckDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 盘点编码 */
    @Excel(name = "盘点编码")
    private String checkCode;

    /** 责任人 */
    @Excel(name = "责任人")
    private String responsiber;

    /** 账户 */
    @Excel(name = "账户")
    private String resouceAccount;

    /** 账户备注 */
    @Excel(name = "账户备注")
    private String resourceAccountRemark;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal fundAmount;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    private List<String> imgUrls;

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
    public void setCheckCode(String checkCode) 
    {
        this.checkCode = checkCode;
    }

    public String getCheckCode() 
    {
        return checkCode;
    }
    public void setResponsiber(String responsiber) 
    {
        this.responsiber = responsiber;
    }

    public String getResponsiber() 
    {
        return responsiber;
    }
    public void setResouceAccount(String resouceAccount) 
    {
        this.resouceAccount = resouceAccount;
    }

    public String getResouceAccount() 
    {
        return resouceAccount;
    }
    public void setResourceAccountRemark(String resourceAccountRemark) 
    {
        this.resourceAccountRemark = resourceAccountRemark;
    }

    public String getResourceAccountRemark() 
    {
        return resourceAccountRemark;
    }
    public void setFundAmount(BigDecimal fundAmount) 
    {
        this.fundAmount = fundAmount;
    }

    public BigDecimal getFundAmount() 
    {
        return fundAmount;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
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
            .append("checkCode", getCheckCode())
            .append("responsiber", getResponsiber())
            .append("resouceAccount", getResouceAccount())
            .append("resourceAccountRemark", getResourceAccountRemark())
            .append("fundAmount", getFundAmount())
            .append("remark", getRemark())
            .append("img", getImg())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
