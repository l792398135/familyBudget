package com.ruoyi.finance.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.finance.mapper.FamilyProjectManageMapper;
import com.ruoyi.finance.domain.FamilyProjectManage;
import com.ruoyi.finance.service.IFamilyProjectManageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
@Service
public class FamilyProjectManageServiceImpl implements IFamilyProjectManageService 
{
    @Autowired
    private FamilyProjectManageMapper familyProjectManageMapper;
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;
    /**
     * 查询项目管理
     * 
     * @param id 项目管理主键
     * @return 项目管理
     */
    @Override
    public FamilyProjectManage selectFamilyProjectManageById(Long id)
    {
        return familyProjectManageMapper.selectFamilyProjectManageById(id);
    }

    /**
     * 查询项目管理列表
     * 
     * @param familyProjectManage 项目管理
     * @return 项目管理
     */
    @Override
    public List<FamilyProjectManage> selectFamilyProjectManageList(FamilyProjectManage familyProjectManage)
    {
        List<FamilyProjectManage> familyProjectManages = familyProjectManageMapper.selectFamilyProjectManageList(familyProjectManage);
        for (int i = 0; i <familyProjectManages.size() ; i++) {
            FamilyProjectManage fixedAssets =familyProjectManages.get(i);
            Long id = fixedAssets.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("projectManage");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                fixedAssets.setImgUrls(collect);
            }
            familyProjectManages.set(i,fixedAssets);
        }
        return familyProjectManages;
    }

    /**
     * 新增项目管理
     * 
     * @param familyProjectManage 项目管理
     * @return 结果
     */
    @Override
    public Long insertFamilyProjectManage(FamilyProjectManage familyProjectManage)
    {
        familyProjectManage.setCreateUser(ShiroUtils.getLoginName());
        familyProjectManage.setCreateTime(DateUtils.getNowDate());
        int i = familyProjectManageMapper.insertFamilyProjectManage(familyProjectManage);
        return familyProjectManage.getId();
    }

    /**
     * 修改项目管理
     * 
     * @param familyProjectManage 项目管理
     * @return 结果
     */
    @Override
    public int updateFamilyProjectManage(FamilyProjectManage familyProjectManage)
    {
        return familyProjectManageMapper.updateFamilyProjectManage(familyProjectManage);
    }

    /**
     * 批量删除项目管理
     * 
     * @param ids 需要删除的项目管理主键
     * @return 结果
     */
    @Override
    public int deleteFamilyProjectManageByIds(String ids)
    {
        return familyProjectManageMapper.deleteFamilyProjectManageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目管理信息
     * 
     * @param id 项目管理主键
     * @return 结果
     */
    @Override
    public int deleteFamilyProjectManageById(Long id)
    {
        return familyProjectManageMapper.deleteFamilyProjectManageById(id);
    }
}
