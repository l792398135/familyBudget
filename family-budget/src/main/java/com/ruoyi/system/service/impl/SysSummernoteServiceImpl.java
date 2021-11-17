package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysSummernoteMapper;
import com.ruoyi.system.domain.SysSummernote;
import com.ruoyi.system.service.ISysSummernoteService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 富文本数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
@Service
public class SysSummernoteServiceImpl implements ISysSummernoteService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private SysSummernoteMapper sysSummernoteMapper;

    /**
     * 查询富文本数据
     * 
     * @param id 富文本数据主键
     * @return 富文本数据
     */
    @Override
    public SysSummernote selectSysSummernoteById(Long id)
    {
        return sysSummernoteMapper.selectSysSummernoteById(id);
    }

    /**
     * 查询富文本数据列表
     * 
     * @param sysSummernote 富文本数据
     * @return 富文本数据
     */
    @Override
    public List<SysSummernote> selectSysSummernoteList(SysSummernote sysSummernote)
    {
        List<SysSummernote> sysSummernote1= sysSummernoteMapper.selectSysSummernoteList(sysSummernote);
        for (int i = 0; i <sysSummernote1.size() ; i++) {
            SysSummernote item =sysSummernote1.get(i);
            Long id = item.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("businessType");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                item.setImgUrls(collect);
            }
            sysSummernote1.set(i,item);
        }
        return sysSummernote1;
    }

    /**
     * 新增富文本数据
     * 
     * @param sysSummernote 富文本数据
     * @return 结果
     */
    @Override
    public Long insertSysSummernote(SysSummernote sysSummernote)
    {
        sysSummernote.setCreateTime(DateUtils.getNowDate());
        sysSummernote.setCreateUser(ShiroUtils.getLoginName());
        sysSummernoteMapper.insertSysSummernote(sysSummernote);
        return sysSummernote.getId();
    }

    /**
     * 修改富文本数据
     * 
     * @param sysSummernote 富文本数据
     * @return 结果
     */
    @Override
    public int updateSysSummernote(SysSummernote sysSummernote)
    {
        return sysSummernoteMapper.updateSysSummernote(sysSummernote);
    }

    /**
     * 批量删除富文本数据
     * 
     * @param ids 需要删除的富文本数据主键
     * @return 结果
     */
    @Override
    public int deleteSysSummernoteByIds(String ids)
    {
        return sysSummernoteMapper.deleteSysSummernoteByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除富文本数据信息
     * 
     * @param id 富文本数据主键
     * @return 结果
     */
    @Override
    public int deleteSysSummernoteById(Long id)
    {
        return sysSummernoteMapper.deleteSysSummernoteById(id);
    }

    @Override
    public SysSummernote selectSysSummernote(SysSummernote sysSummernote) {
        return sysSummernoteMapper.selectSysSummernote(sysSummernote);
    }
}
