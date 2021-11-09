package com.ruoyi.finance.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目管理对象 family_project_manage
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
public class FamilyProjectManage extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    private List<String> imgUrls;
    /**  */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 负责人 */
    @Excel(name = "负责人")
    private String projectMenber;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 投资金额 */
    @Excel(name = "投资金额")
    private BigDecimal investAmount;

    /** 以投资金额 */
    @Excel(name = "以投资金额")
    private BigDecimal investedAmount;

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
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectMenber(String projectMenber) 
    {
        this.projectMenber = projectMenber;
    }

    public String getProjectMenber() 
    {
        return projectMenber;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setInvestAmount(BigDecimal investAmount) 
    {
        this.investAmount = investAmount;
    }

    public BigDecimal getInvestAmount() 
    {
        return investAmount;
    }
    public void setInvestedAmount(BigDecimal investedAmount) 
    {
        this.investedAmount = investedAmount;
    }

    public BigDecimal getInvestedAmount() 
    {
        return investedAmount;
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
            .append("projectName", getProjectName())
            .append("projectMenber", getProjectMenber())
            .append("startTime", getStartTime())
            .append("endDate", getEndDate())
            .append("investAmount", getInvestAmount())
            .append("investedAmount", getInvestedAmount())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
