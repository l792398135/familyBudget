package com.ruoyi.car.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆维护费用对象 family_car_repair
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
public class FamilyCarRepair extends BaseEntity
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

    /** 车辆编码 */
    @Excel(name = "车辆编码")
    private String carCode;

    /** 车辆花费编码 */
    @Excel(name = "车辆花费编码")
    private String carRepairCode;

    /** 花费 */
    @Excel(name = "花费")
    private BigDecimal carCost;

    /** 支出人 */
    @Excel(name = "支出人")
    private String payMenber;

    private Long businessId;

    /** 支出日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支出日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payDate;

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
    public void setCarCode(String carCode) 
    {
        this.carCode = carCode;
    }

    public String getCarCode() 
    {
        return carCode;
    }
    public void setCarRepairCode(String carRepairCode) 
    {
        this.carRepairCode = carRepairCode;
    }

    public String getCarRepairCode() 
    {
        return carRepairCode;
    }
    public void setCarCost(BigDecimal carCost) 
    {
        this.carCost = carCost;
    }

    public BigDecimal getCarCost() 
    {
        return carCost;
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
            .append("carRepairCode", getCarRepairCode())
            .append("carCost", getCarCost())
            .append("payMenber", getPayMenber())
            .append("payDate", getPayDate())
            .append("remark", getRemark())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
