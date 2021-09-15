package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 附件对象 sys_attachment
 * 
 * @author ruoyi
 * @date 2021-09-14
 */
public class SysAttachment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 业务类型 */
    @Excel(name = "业务类型")
    private String businessType;

    /** 业务Id */
    @Excel(name = "业务Id")
    private String businessId;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 真实的文件名 */
    @Excel(name = "真实的文件名")
    private String fileNameReal;

    /** 显示用的文件名 */
    @Excel(name = "显示用的文件名")
    private String fileNameShow;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Integer fileSize;

    /** 删除标记 */
    private Integer delFlag;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
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
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setFileNameReal(String fileNameReal) 
    {
        this.fileNameReal = fileNameReal;
    }

    public String getFileNameReal() 
    {
        return fileNameReal;
    }
    public void setFileNameShow(String fileNameShow) 
    {
        this.fileNameShow = fileNameShow;
    }

    public String getFileNameShow() 
    {
        return fileNameShow;
    }
    public void setFileSize(Integer fileSize) 
    {
        this.fileSize = fileSize;
    }

    public Integer getFileSize() 
    {
        return fileSize;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("businessType", getBusinessType())
            .append("businessId", getBusinessId())
            .append("filePath", getFilePath())
            .append("fileNameReal", getFileNameReal())
            .append("fileNameShow", getFileNameShow())
            .append("fileSize", getFileSize())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .toString();
    }
}
