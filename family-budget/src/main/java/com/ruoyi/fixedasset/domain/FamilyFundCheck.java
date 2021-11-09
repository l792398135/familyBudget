package com.ruoyi.fixedasset.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 盘点对象 family_fund_check
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
public class FamilyFundCheck extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 盘点编码 */
    @Excel(name = "盘点编码")
    private String checkCode;

    /** 盘点名称 */
    @Excel(name = "盘点名称")
    private String checkName;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 启用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "启用时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

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
    public void setCheckCode(String checkCode) 
    {
        this.checkCode = checkCode;
    }

    public String getCheckCode() 
    {
        return checkCode;
    }
    public void setCheckName(String checkName) 
    {
        this.checkName = checkName;
    }

    public String getCheckName() 
    {
        return checkName;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
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
            .append("checkName", getCheckName())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("startTime", getStartTime())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
