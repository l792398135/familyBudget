package com.ruoyi.car.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.FamilyCarMangecMapper;
import com.ruoyi.car.domain.FamilyCarMangec;
import com.ruoyi.car.service.IFamilyCarMangecService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 车辆管理基础数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
@Service
public class FamilyCarMangecServiceImpl implements IFamilyCarMangecService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyCarMangecMapper familyCarMangecMapper;

    /**
     * 查询车辆管理基础数据
     * 
     * @param id 车辆管理基础数据主键
     * @return 车辆管理基础数据
     */
    @Override
    public FamilyCarMangec selectFamilyCarMangecById(Long id)
    {
        return familyCarMangecMapper.selectFamilyCarMangecById(id);
    }

    /**
     * 查询车辆管理基础数据列表
     * 
     * @param familyCarMangec 车辆管理基础数据
     * @return 车辆管理基础数据
     */
    @Override
    public List<FamilyCarMangec> selectFamilyCarMangecList(FamilyCarMangec familyCarMangec)
    {
        List<FamilyCarMangec> familyCarMangec1= familyCarMangecMapper.selectFamilyCarMangecList(familyCarMangec);
        for (int i = 0; i <familyCarMangec1.size() ; i++) {
            FamilyCarMangec item =familyCarMangec1.get(i);
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
            familyCarMangec1.set(i,item);
        }
        return familyCarMangec1;
    }

    /**
     * 新增车辆管理基础数据
     * 
     * @param familyCarMangec 车辆管理基础数据
     * @return 结果
     */
    @Override
    public Long insertFamilyCarMangec(FamilyCarMangec familyCarMangec)
    {
        familyCarMangec.setCreateTime(DateUtils.getNowDate());
        familyCarMangec.setCreateUser(ShiroUtils.getLoginName());
        familyCarMangecMapper.insertFamilyCarMangec(familyCarMangec);
        return familyCarMangec.getId();
    }

    /**
     * 修改车辆管理基础数据
     * 
     * @param familyCarMangec 车辆管理基础数据
     * @return 结果
     */
    @Override
    public int updateFamilyCarMangec(FamilyCarMangec familyCarMangec)
    {
        return familyCarMangecMapper.updateFamilyCarMangec(familyCarMangec);
    }

    /**
     * 批量删除车辆管理基础数据
     * 
     * @param ids 需要删除的车辆管理基础数据主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarMangecByIds(String ids)
    {
        return familyCarMangecMapper.deleteFamilyCarMangecByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆管理基础数据信息
     * 
     * @param id 车辆管理基础数据主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarMangecById(Long id)
    {
        return familyCarMangecMapper.deleteFamilyCarMangecById(id);
    }
}
