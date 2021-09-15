package com.ruoyi.system.service.impl;

import java.io.File;
import java.util.List;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysAttachmentMapper;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.service.ISysAttachmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 附件Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-14
 */
@Service
public class SysAttachmentServiceImpl implements ISysAttachmentService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    /**
     * 查询附件
     * 
     * @param id 附件主键
     * @return 附件
     */
    @Override
    public SysAttachment selectSysAttachmentById(Integer id)
    {
        return sysAttachmentMapper.selectSysAttachmentById(id);
    }

    /**
     * 查询附件列表
     * 
     * @param sysAttachment 附件
     * @return 附件
     */
    @Override
    public List<SysAttachment> selectSysAttachmentList(SysAttachment sysAttachment)
    {
        return sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
    }

    /**
     * 新增附件
     * 
     * @param sysAttachment 附件
     * @return 结果
     */
    @Override
    public int insertSysAttachment(SysAttachment sysAttachment)
    {
        sysAttachment.setCreateTime(DateUtils.getNowDate());
        return sysAttachmentMapper.insertSysAttachment(sysAttachment);
    }

    /**
     * 修改附件
     * 
     * @param sysAttachment 附件
     * @return 结果
     */
    @Override
    public int updateSysAttachment(SysAttachment sysAttachment)
    {
        return sysAttachmentMapper.updateSysAttachment(sysAttachment);
    }

    /**
     * 批量删除附件
     * 
     * @param ids 需要删除的附件主键
     * @return 结果
     */
    @Override
    public int deleteSysAttachmentByIds(String ids)
    {
        String[] strings = Convert.toStrArray(ids);
        for (String string : strings) {
            int i = Integer.parseInt(string);
            SysAttachment sysAttachment = sysAttachmentMapper.selectSysAttachmentById(i);
            String fileNameReal = sysAttachment.getFileNameReal();
            String filePath = RuoYiConfig.getUploadPath();
            String substring = fileNameReal.substring(15);
            File file = new File(filePath + substring);
            if (file.isFile()){
                file.delete();
            }
        }
        return sysAttachmentMapper.deleteSysAttachmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除附件信息
     * 
     * @param id 附件主键
     * @return 结果
     */
    @Override
    public int deleteSysAttachmentById(Integer id)
    {
        return sysAttachmentMapper.deleteSysAttachmentById(id);
    }
}
