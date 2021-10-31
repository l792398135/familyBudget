package com.ruoyi.car.service;

import java.util.List;
import com.ruoyi.car.domain.FamilyCarRepair;

/**
 * 车辆维护费用Service接口
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
public interface IFamilyCarRepairService 
{
    /**
     * 查询车辆维护费用
     * 
     * @param id 车辆维护费用主键
     * @return 车辆维护费用
     */
    public FamilyCarRepair selectFamilyCarRepairById(Long id);

    /**
     * 查询车辆维护费用列表
     * 
     * @param familyCarRepair 车辆维护费用
     * @return 车辆维护费用集合
     */
    public List<FamilyCarRepair> selectFamilyCarRepairList(FamilyCarRepair familyCarRepair);

    /**
     * 新增车辆维护费用
     * 
     * @param familyCarRepair 车辆维护费用
     * @return 结果
     */
    public Long insertFamilyCarRepair(FamilyCarRepair familyCarRepair);

    /**
     * 修改车辆维护费用
     * 
     * @param familyCarRepair 车辆维护费用
     * @return 结果
     */
    public int updateFamilyCarRepair(FamilyCarRepair familyCarRepair);

    /**
     * 批量删除车辆维护费用
     * 
     * @param ids 需要删除的车辆维护费用主键集合
     * @return 结果
     */
    public int deleteFamilyCarRepairByIds(String ids);

    /**
     * 删除车辆维护费用信息
     * 
     * @param id 车辆维护费用主键
     * @return 结果
     */
    public int deleteFamilyCarRepairById(Long id);
}
