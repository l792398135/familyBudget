package com.ruoyi.base.mapper;

import java.util.List;
import com.ruoyi.base.domain.FamilyCarRepairBase;

/**
 * 车辆保养科目Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
public interface FamilyCarRepairBaseMapper 
{
    /**
     * 查询车辆保养科目
     * 
     * @param id 车辆保养科目主键
     * @return 车辆保养科目
     */
    public FamilyCarRepairBase selectFamilyCarRepairBaseById(Long id);

    /**
     * 查询车辆保养科目列表
     * 
     * @param familyCarRepairBase 车辆保养科目
     * @return 车辆保养科目集合
     */
    public List<FamilyCarRepairBase> selectFamilyCarRepairBaseList(FamilyCarRepairBase familyCarRepairBase);

    /**
     * 新增车辆保养科目
     * 
     * @param familyCarRepairBase 车辆保养科目
     * @return 结果
     */
    public int insertFamilyCarRepairBase(FamilyCarRepairBase familyCarRepairBase);

    /**
     * 修改车辆保养科目
     * 
     * @param familyCarRepairBase 车辆保养科目
     * @return 结果
     */
    public int updateFamilyCarRepairBase(FamilyCarRepairBase familyCarRepairBase);

    /**
     * 删除车辆保养科目
     * 
     * @param id 车辆保养科目主键
     * @return 结果
     */
    public int deleteFamilyCarRepairBaseById(Long id);

    /**
     * 批量删除车辆保养科目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyCarRepairBaseByIds(String[] ids);
}
