package com.ruoyi.car.service.impl;

import com.ruoyi.base.controller.FamilyCarMangeController;
import com.ruoyi.base.domain.FamilyCarMange;
import com.ruoyi.base.mapper.FamilyCarMangeMapper;
import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.FamilyCarRepairBase1Mapper;
import com.ruoyi.car.domain.FamilyCarRepairBase1;
import com.ruoyi.car.service.IFamilyCarRepairBase1Service;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 车辆保养科目Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
@Service
public class FamilyCarRepairBase1ServiceImpl implements IFamilyCarRepairBase1Service 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyCarRepairBase1Mapper familyCarRepairBase1Mapper;

    @Autowired
    private FamilyCarMangeMapper familyCarMangeMapper;
    /**
     * 查询车辆保养科目
     * 
     * @param id 车辆保养科目主键
     * @return 车辆保养科目
     */
    @Override
    public FamilyCarRepairBase1 selectFamilyCarRepairBase1ById(Long id)
    {
        return familyCarRepairBase1Mapper.selectFamilyCarRepairBase1ById(id);
    }

    /**
     * 查询车辆保养科目列表
     * 
     * @param familyCarRepairBase1 车辆保养科目
     * @return 车辆保养科目
     */
    @Override
    public List<FamilyCarRepairBase1> selectFamilyCarRepairBase1List(FamilyCarRepairBase1 familyCarRepairBase1)
    {
        List<FamilyCarRepairBase1> familyCarRepairBase11= familyCarRepairBase1Mapper.selectFamilyCarRepairBase1List(familyCarRepairBase1);
        for (int i = 0; i <familyCarRepairBase11.size() ; i++) {
            FamilyCarRepairBase1 item =familyCarRepairBase11.get(i);
            Long id = item.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("carRepair");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                item.setImgUrls(collect);
            }
            familyCarRepairBase11.set(i,item);
        }
        return familyCarRepairBase11;
    }

    /**
     * 新增车辆保养科目
     * 
     * @param familyCarRepairBase1 车辆保养科目
     * @return 结果
     */
    @Override
    public Long insertFamilyCarRepairBase1(FamilyCarRepairBase1 familyCarRepairBase1)
    {
        familyCarRepairBase1.setCreateTime(DateUtils.getNowDate());
        familyCarRepairBase1.setCreateUser(ShiroUtils.getLoginName());
        familyCarRepairBase1Mapper.insertFamilyCarRepairBase1(familyCarRepairBase1);
        return familyCarRepairBase1.getId();
    }

    /**
     * 修改车辆保养科目
     * 
     * @param familyCarRepairBase1 车辆保养科目
     * @return 结果
     */
    @Override
    public int updateFamilyCarRepairBase1(FamilyCarRepairBase1 familyCarRepairBase1)
    {
        return familyCarRepairBase1Mapper.updateFamilyCarRepairBase1(familyCarRepairBase1);
    }

    /**
     * 批量删除车辆保养科目
     * 
     * @param ids 需要删除的车辆保养科目主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarRepairBase1ByIds(String ids)
    {
        return familyCarRepairBase1Mapper.deleteFamilyCarRepairBase1ByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆保养科目信息
     * 
     * @param id 车辆保养科目主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarRepairBase1ById(Long id)
    {
        return familyCarRepairBase1Mapper.deleteFamilyCarRepairBase1ById(id);
    }
}
