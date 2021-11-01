package com.ruoyi.base.service.impl;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.mapper.SysDictDataMapper;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.base.mapper.FamilyCarRepairBaseMapper;
import com.ruoyi.base.domain.FamilyCarRepairBase;
import com.ruoyi.base.service.IFamilyCarRepairBaseService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 车辆保养科目Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
@Service
public class FamilyCarRepairBaseServiceImpl implements IFamilyCarRepairBaseService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyCarRepairBaseMapper familyCarRepairBaseMapper;
    @Autowired
    private SysDictDataMapper sysDictDataMapper;
    /**
     * 查询车辆保养科目
     * 
     * @param id 车辆保养科目主键
     * @return 车辆保养科目
     */
    @Override
    public FamilyCarRepairBase selectFamilyCarRepairBaseById(Long id)
    {
        return familyCarRepairBaseMapper.selectFamilyCarRepairBaseById(id);
    }

    /**
     * 查询车辆保养科目列表
     * 
     * @param familyCarRepairBase 车辆保养科目
     * @return 车辆保养科目
     */
    @Override
    public List<FamilyCarRepairBase> selectFamilyCarRepairBaseList(FamilyCarRepairBase familyCarRepairBase)
    {
        List<FamilyCarRepairBase> familyCarRepairBase1= familyCarRepairBaseMapper.selectFamilyCarRepairBaseList(familyCarRepairBase);
        for (int i = 0; i <familyCarRepairBase1.size() ; i++) {
            FamilyCarRepairBase item =familyCarRepairBase1.get(i);
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
            familyCarRepairBase1.set(i,item);
        }
        return familyCarRepairBase1;
    }

    /**
     * 新增车辆保养科目
     * 
     * @param familyCarRepairBase 车辆保养科目
     * @return 结果
     */
    @Override
    public Long insertFamilyCarRepairBase(FamilyCarRepairBase familyCarRepairBase)
    {
        familyCarRepairBase.setCreateTime(DateUtils.getNowDate());
        familyCarRepairBase.setCreateUser(ShiroUtils.getLoginName());
        familyCarRepairBaseMapper.insertFamilyCarRepairBase(familyCarRepairBase);
        return familyCarRepairBase.getId();
    }

    /**
     * 修改车辆保养科目
     * 
     * @param familyCarRepairBase 车辆保养科目
     * @return 结果
     */
    @Override
    public int updateFamilyCarRepairBase(FamilyCarRepairBase familyCarRepairBase)
    {
        return familyCarRepairBaseMapper.updateFamilyCarRepairBase(familyCarRepairBase);
    }

    /**
     * 批量删除车辆保养科目
     * 
     * @param ids 需要删除的车辆保养科目主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarRepairBaseByIds(String ids)
    {
        return familyCarRepairBaseMapper.deleteFamilyCarRepairBaseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆保养科目信息
     * 
     * @param id 车辆保养科目主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCarRepairBaseById(Long id)
    {
        return familyCarRepairBaseMapper.deleteFamilyCarRepairBaseById(id);
    }

    @Override
    public void refresh(String carCode) {

        List<SysDictData> carRepair = sysDictDataMapper.selectDictDataByType("car_repair");

        FamilyCarRepairBase familyCarRepairBase = new FamilyCarRepairBase();
        familyCarRepairBase.setCarCode(carCode);
        List<FamilyCarRepairBase> familyCarRepairBases = familyCarRepairBaseMapper.selectFamilyCarRepairBaseList(familyCarRepairBase);

        for (SysDictData sysDictData : carRepair) {
            String dictValue = sysDictData.getDictValue();
            if (!CollectionUtils.isEmpty(familyCarRepairBases)){
                List<FamilyCarRepairBase> collect = familyCarRepairBases.stream().filter(r -> r.getCarRepairCode().equals(dictValue)).collect(Collectors.toList());
                if (collect.size() == 0) {
                    FamilyCarRepairBase familyCarRepairBase1 = new FamilyCarRepairBase();
                    familyCarRepairBase1.setCarCode(carCode);
                    familyCarRepairBase1.setCarRepairCode(sysDictData.getDictValue());
                    familyCarRepairBase1.setEffectiveFlag("Y");
                    familyCarRepairBase1.setCarRepairMile(10000L);
                    familyCarRepairBase1.setCarRepairCycle(12L);
                    familyCarRepairBase1.setCarRepairCycleCall(10L);
                    familyCarRepairBase1.setCarRepairMileCall(500L);
                    familyCarRepairBaseMapper.insertFamilyCarRepairBase(familyCarRepairBase1);
                }
            }else{
                FamilyCarRepairBase familyCarRepairBase1 = new FamilyCarRepairBase();
                familyCarRepairBase1.setCarCode(carCode);
                familyCarRepairBase1.setCarRepairCode(sysDictData.getDictValue());
                familyCarRepairBase1.setEffectiveFlag("Y");
                familyCarRepairBase1.setCarRepairMile(10000L);
                familyCarRepairBase1.setCarRepairCycle(12L);
                familyCarRepairBase1.setCarRepairCycleCall(10L);
                familyCarRepairBase1.setCarRepairMileCall(500L);
                familyCarRepairBaseMapper.insertFamilyCarRepairBase(familyCarRepairBase1);
            }

        }


    }
}
