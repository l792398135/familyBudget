package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.FamilyCarRepair;

/**
 * 车辆维护费用Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
public interface FamilyCarRepairMapper 
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
    public int insertFamilyCarRepair(FamilyCarRepair familyCarRepair);

    /**
     * 修改车辆维护费用
     * 
     * @param familyCarRepair 车辆维护费用
     * @return 结果
     */
    public int updateFamilyCarRepair(FamilyCarRepair familyCarRepair);

    /**
     * 删除车辆维护费用
     * 
     * @param id 车辆维护费用主键
     * @return 结果
     */
    public int deleteFamilyCarRepairById(Long id);

    /**
     * 批量删除车辆维护费用
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyCarRepairByIds(String[] ids);
}
