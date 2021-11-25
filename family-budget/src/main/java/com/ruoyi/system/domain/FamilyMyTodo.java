package com.ruoyi.system.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页通知对象 family_my_todo
 * 
 * @author ruoyi
 * @date 2021-11-25
 */
public class FamilyMyTodo extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    /**  */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 是否确认 */
    @Excel(name = "是否确认")
    private String doFlag;

    /** 负责人 */
    @Excel(name = "负责人")
    private String responsibler;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date doTime;

    public Date getDoTime() {
        return doTime;
    }

    public void setDoTime(Date doTime) {
        this.doTime = doTime;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDoFlag(String doFlag) 
    {
        this.doFlag = doFlag;
    }

    public String getDoFlag() 
    {
        return doFlag;
    }
    public void setResponsibler(String responsibler) 
    {
        this.responsibler = responsibler;
    }

    public String getResponsibler() 
    {
        return responsibler;
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
            .append("title", getTitle())
            .append("content", getContent())
            .append("doFlag", getDoFlag())
            .append("responsibler", getResponsibler())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
