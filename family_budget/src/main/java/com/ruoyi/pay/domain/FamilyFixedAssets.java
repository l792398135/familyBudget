package com.ruoyi.pay.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 固定资产对象 family_fixed_assets
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public class FamilyFixedAssets extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String model;

    /** 使用人员 */
    @Excel(name = "使用人员")
    private String useMenber;

    /** 使用情况 */
    @Excel(name = "使用情况")
    private String usage;

    /** 数量 */
    @Excel(name = "数量")
    private Long num;

    /** 购入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buyDate;

    /** 购入费用 */
    @Excel(name = "购入费用")
    private BigDecimal buyCost;

    /** 存放地点 */
    @Excel(name = "存放地点")
    private String position;

    /** 责任人 */
    @Excel(name = "责任人")
    private String responsibler;

    /** 图片 */
    @Excel(name = "图片")
    private String imgUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }
    public void setUseMenber(String useMenber) 
    {
        this.useMenber = useMenber;
    }

    public String getUseMenber() 
    {
        return useMenber;
    }
    public void setUsage(String usage) 
    {
        this.usage = usage;
    }

    public String getUsage() 
    {
        return usage;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }
    public void setBuyDate(Date buyDate) 
    {
        this.buyDate = buyDate;
    }

    public Date getBuyDate() 
    {
        return buyDate;
    }
    public void setBuyCost(BigDecimal buyCost) 
    {
        this.buyCost = buyCost;
    }

    public BigDecimal getBuyCost() 
    {
        return buyCost;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setResponsibler(String responsibler) 
    {
        this.responsibler = responsibler;
    }

    public String getResponsibler() 
    {
        return responsibler;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("model", getModel())
            .append("useMenber", getUseMenber())
            .append("usage", getUsage())
            .append("num", getNum())
            .append("buyDate", getBuyDate())
            .append("buyCost", getBuyCost())
            .append("position", getPosition())
            .append("responsibler", getResponsibler())
            .append("remark", getRemark())
            .append("imgUrl", getImgUrl())
            .toString();
    }
}
