package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.FamilyCarRepairBase1;

/**
 * 车辆保养科目Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
public interface FamilyCarRepairBase1Mapper 
{
    /**
     * 查询车辆保养科目
     * 
     * @param id 车辆保养科目主键
     * @return 车辆保养科目
     */
    public FamilyCarRepairBase1 selectFamilyCarRepairBase1ById(Long id);

    /**
     * 查询车辆保养科目列表
     * 
     * @param familyCarRepairBase1 车辆保养科目
     * @return 车辆保养科目集合
     */
    public List<FamilyCarRepairBase1> selectFamilyCarRepairBase1List(FamilyCarRepairBase1 familyCarRepairBase1);

    /**
     * 新增车辆保养科目
     * 
     * @param familyCarRepairBase1 车辆保养科目
     * @return 结果
     */
    public int insertFamilyCarRepairBase1(FamilyCarRepairBase1 familyCarRepairBase1);

    /**
     * 修改车辆保养科目
     * 
     * @param familyCarRepairBase1 车辆保养科目
     * @return 结果
     */
    public int updateFamilyCarRepairBase1(FamilyCarRepairBase1 familyCarRepairBase1);

    /**
     * 删除车辆保养科目
     * 
     * @param id 车辆保养科目主键
     * @return 结果
     */
    public int deleteFamilyCarRepairBase1ById(Long id);

    /**
     * 批量删除车辆保养科目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyCarRepairBase1ByIds(String[] ids);
}
