package com.ruoyi.base.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆管理基础数据对象 family_car_mange
 * 
 * @author ruoyi
 * @date 2021-10-26
 */
public class FamilyCarMange extends BaseEntity
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

    /** 车子编码 */
    @Excel(name = "车子编码")
    private String carCode;

    /** 行驶里程 */
    @Excel(name = "行驶里程")
    private Long carMile;

    /** 负责人 */
    @Excel(name = "负责人")
    private String responsibler;

    /** 购买花费 */
    @Excel(name = "购买花费")
    private BigDecimal carBuyCost;

    /** 购买日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buyDate;

    /** 车牌 */
    @Excel(name = "车牌")
    private String carId;

    /** 是否有效 */
    @Excel(name = "是否有效")
    private String effectiveFlag;

    /** 创建人 */
    private String createUser;

    public Long getCarMile() {
        return carMile;
    }

    public void setCarMile(Long carMile) {
        this.carMile = carMile;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCarCode(String carCode) 
    {
        this.carCode = carCode;
    }

    public String getCarCode() 
    {
        return carCode;
    }
    public void setResponsibler(String responsibler) 
    {
        this.responsibler = responsibler;
    }

    public String getResponsibler() 
    {
        return responsibler;
    }
    public void setCarBuyCost(BigDecimal carBuyCost) 
    {
        this.carBuyCost = carBuyCost;
    }

    public BigDecimal getCarBuyCost() 
    {
        return carBuyCost;
    }
    public void setBuyDate(Date buyDate) 
    {
        this.buyDate = buyDate;
    }

    public Date getBuyDate() 
    {
        return buyDate;
    }
    public void setCarId(String carId) 
    {
        this.carId = carId;
    }

    public String getCarId() 
    {
        return carId;
    }
    public void setEffectiveFlag(String effectiveFlag) 
    {
        this.effectiveFlag = effectiveFlag;
    }

    public String getEffectiveFlag() 
    {
        return effectiveFlag;
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
            .append("carCode", getCarCode())
            .append("responsibler", getResponsibler())
            .append("carBuyCost", getCarBuyCost())
            .append("buyDate", getBuyDate())
            .append("carId", getCarId())
            .append("remark", getRemark())
            .append("effectiveFlag", getEffectiveFlag())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
