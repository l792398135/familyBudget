package com.ruoyi.car.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.FamilyCarRepairMapper;
import com.ruoyi.car.domain.FamilyCarRepair;
import com.ruoyi.car.service.IFamilyCarRepairService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 车辆维护费用Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
@Service
public class FamilyCarRepairServiceImpl implements IFamilyCarRepairService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyCarRepairMapper familyCarRepairMapper;

    /**
     * 查询车辆维护费用
     * 
     * @param id 车辆维护费用主键
     * @return 车辆维护费用
     */
    @Override
    public FamilyCarRepair selectFamilyCarRepairById(Long id)
    {
        return familyCarRepairMapper.selectFamilyCarRepairById(id);
    }

    /**
     * 查询车辆维护费用列表
     * 
     * @param familyCarRepair 车辆维护费用
     * @return 车辆维护费用
     */
    @Override
    public List<FamilyCarRepair> selectFamilyCarRepairList(FamilyCarRepair familyCarRepair)
    {
        List<FamilyCarRepair> familyCarRepair1= familyCarRepairMapper.selectFamilyCarRepairList(familyCarRepair);
        for (int i = 0; i <familyCarRepair1.size() ; i++) {
            FamilyCarRepair item =familyCarRepair1.get(i);
            Long id = item.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("carRepairCost");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                item.setImgUrls(collect);
            }
            familyCarRepair1.set(i,item);
        }
        return familyCarRepair1;
    }

    /**
     * 新增车辆维护费用
     * 
     * @param familyCarRepair 车辆维护费用
     * @return 结果
     */
    @Override
    public Long insertFamilyCarRepair(FamilyCarRepair familyCarRepair)
    {
        familyCarRepair.setCreateTime(DateUtils.getNowDate());
        familyCarRepair.setCreateUser(ShiroUtils.getLoginName());
        familyCarRepairMapper.insertFamilyCarRepair(familyCarRepair);
        return familyCarRepair.getId();
    }

    /**
     * 修改车辆维护费用
     * 
     * @param familyCarRepair 车辆维护费用
     * @return 结果
     */
    @Override
    public int updateFamilyCarRepair(FamilyCarRepair familyCarRepair)
    {
        return familyCarRepairMapper.updateFamilyCarRepair(familyCarRepair);
    }

    /**
     * 批量删除车辆维护费用
     * 
     * @param ids 需要删除的车辆维护费用主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarRepairByIds(String ids)
    {
        return familyCarRepairMapper.deleteFamilyCarRepairByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆维护费用信息
     * 
     * @param id 车辆维护费用主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarRepairById(Long id)
    {
        return familyCarRepairMapper.deleteFamilyCarRepairById(id);
    }
}
