package com.ruoyi.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 富文本数据对象 sys_summernote
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
public class SysSummernote extends BaseEntity
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

    /** 业务类型 */
    @Excel(name = "业务类型")
    private String businessType;

    /** 业务id */
    @Excel(name = "业务id")
    private String businessId;

    /** 文本 */
    @Excel(name = "文本")
    private String summernote;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

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
    public void setBusinessType(String businessType) 
    {
        this.businessType = businessType;
    }

    public String getBusinessType() 
    {
        return businessType;
    }
    public void setBusinessId(String businessId) 
    {
        this.businessId = businessId;
    }

    public String getBusinessId() 
    {
        return businessId;
    }
    public void setSummernote(String summernote) 
    {
        this.summernote = summernote;
    }

    public String getSummernote() 
    {
        return summernote;
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
            .append("businessType", getBusinessType())
            .append("businessId", getBusinessId())
            .append("summernote", getSummernote())
            .append("status", getStatus())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .toString();
    }
}
