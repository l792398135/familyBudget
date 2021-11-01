package com.ruoyi.car.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆保养科目对象 family_car_repair_base
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
public class FamilyCarRepairBase1 extends BaseEntity
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

    /** 保养周期(月） */
    @Excel(name = "保养周期(月）")
    private Long carRepairCycle;

    /** 保养里程(公里) */
    @Excel(name = "保养里程(公里)")
    private Long carRepairMile;

    /** 上次保养日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上次保养日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date carRepairCycleLast;

    /** 上次保养里程 */
    @Excel(name = "上次保养里程")
    private Long carRepairMileLast;

    /** 周期剩余天报警 */
    @Excel(name = "周期剩余天报警")
    private Long carRepairCycleCall;

    /** 里程剩余报警 */
    @Excel(name = "里程剩余报警")
    private Long carRepairMileCall;

    /** 是否有效 */
    private String effectiveFlag;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 创建人 */
    private String createUser;

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
    public void setCarRepairCycle(Long carRepairCycle) 
    {
        this.carRepairCycle = carRepairCycle;
    }

    public Long getCarRepairCycle() 
    {
        return carRepairCycle;
    }
    public void setCarRepairMile(Long carRepairMile) 
    {
        this.carRepairMile = carRepairMile;
    }

    public Long getCarRepairMile() 
    {
        return carRepairMile;
    }
    public void setCarRepairCycleLast(Date carRepairCycleLast) 
    {
        this.carRepairCycleLast = carRepairCycleLast;
    }

    public Date getCarRepairCycleLast() 
    {
        return carRepairCycleLast;
    }
    public void setCarRepairMileLast(Long carRepairMileLast) 
    {
        this.carRepairMileLast = carRepairMileLast;
    }

    public Long getCarRepairMileLast() 
    {
        return carRepairMileLast;
    }
    public void setCarRepairCycleCall(Long carRepairCycleCall) 
    {
        this.carRepairCycleCall = carRepairCycleCall;
    }

    public Long getCarRepairCycleCall() 
    {
        return carRepairCycleCall;
    }
    public void setCarRepairMileCall(Long carRepairMileCall) 
    {
        this.carRepairMileCall = carRepairMileCall;
    }

    public Long getCarRepairMileCall() 
    {
        return carRepairMileCall;
    }
    public void setEffectiveFlag(String effectiveFlag) 
    {
        this.effectiveFlag = effectiveFlag;
    }

    public String getEffectiveFlag() 
    {
        return effectiveFlag;
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
            .append("carCode", getCarCode())
            .append("carRepairCode", getCarRepairCode())
            .append("carRepairCycle", getCarRepairCycle())
            .append("carRepairMile", getCarRepairMile())
            .append("carRepairCycleLast", getCarRepairCycleLast())
            .append("carRepairMileLast", getCarRepairMileLast())
            .append("carRepairCycleCall", getCarRepairCycleCall())
            .append("carRepairMileCall", getCarRepairMileCall())
            .append("effectiveFlag", getEffectiveFlag())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .toString();
    }
}
