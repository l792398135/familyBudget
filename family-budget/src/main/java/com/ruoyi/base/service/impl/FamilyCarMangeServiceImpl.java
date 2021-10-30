package com.ruoyi.base.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.base.mapper.FamilyCarMangeMapper;
import com.ruoyi.base.domain.FamilyCarMange;
import com.ruoyi.base.service.IFamilyCarMangeService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 车辆管理基础数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-26
 */
@Service
public class FamilyCarMangeServiceImpl implements IFamilyCarMangeService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyCarMangeMapper familyCarMangeMapper;

    /**
     * 查询车辆管理基础数据
     * 
     * @param id 车辆管理基础数据主键
     * @return 车辆管理基础数据
     */
    @Override
    public FamilyCarMange selectFamilyCarMangeById(Long id)
    {
        return familyCarMangeMapper.selectFamilyCarMangeById(id);
    }

    /**
     * 查询车辆管理基础数据列表
     * 
     * @param familyCarMange 车辆管理基础数据
     * @return 车辆管理基础数据
     */
    @Override
    public List<FamilyCarMange> selectFamilyCarMangeList(FamilyCarMange familyCarMange)
    {
        List<FamilyCarMange> familyCarMange1= familyCarMangeMapper.selectFamilyCarMangeList(familyCarMange);
        for (int i = 0; i <familyCarMange1.size() ; i++) {
            FamilyCarMange item =familyCarMange1.get(i);
            Long id = item.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("carManage");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                item.setImgUrls(collect);
            }
            familyCarMange1.set(i,item);
        }
        return familyCarMange1;
    }

    /**
     * 新增车辆管理基础数据
     * 
     * @param familyCarMange 车辆管理基础数据
     * @return 结果
     */
    @Override
    public Long insertFamilyCarMange(FamilyCarMange familyCarMange)
    {
        familyCarMange.setCreateTime(DateUtils.getNowDate());
        familyCarMange.setCreateUser(ShiroUtils.getLoginName());
        familyCarMangeMapper.insertFamilyCarMange(familyCarMange);
        return familyCarMange.getId();
    }

    /**
     * 修改车辆管理基础数据
     * 
     * @param familyCarMange 车辆管理基础数据
     * @return 结果
     */
    @Override
    public int updateFamilyCarMange(FamilyCarMange familyCarMange)
    {
        return familyCarMangeMapper.updateFamilyCarMange(familyCarMange);
    }

    /**
     * 批量删除车辆管理基础数据
     * 
     * @param ids 需要删除的车辆管理基础数据主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarMangeByIds(String ids)
    {
        return familyCarMangeMapper.deleteFamilyCarMangeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆管理基础数据信息
     * 
     * @param id 车辆管理基础数据主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarMangeById(Long id)
    {
        return familyCarMangeMapper.deleteFamilyCarMangeById(id);
    }
}
