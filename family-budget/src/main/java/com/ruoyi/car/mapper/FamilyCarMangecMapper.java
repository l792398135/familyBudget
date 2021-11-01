package com.ruoyi.car.mapper;

import java.util.List;
import com.ruoyi.car.domain.FamilyCarMangec;

/**
 * 车辆管理基础数据Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-31
 */
public interface FamilyCarMangecMapper 
{
    /**
     * 查询车辆管理基础数据
     * 
     * @param id 车辆管理基础数据主键
     * @return 车辆管理基础数据
     */
    public FamilyCarMangec selectFamilyCarMangecById(Long id);

    /**
     * 查询车辆管理基础数据列表
     * 
     * @param familyCarMangec 车辆管理基础数据
     * @return 车辆管理基础数据集合
     */
    public List<FamilyCarMangec> selectFamilyCarMangecList(FamilyCarMangec familyCarMangec);

    /**
     * 新增车辆管理基础数据
     * 
     * @param familyCarMangec 车辆管理基础数据
     * @return 结果
     */
    public int insertFamilyCarMangec(FamilyCarMangec familyCarMangec);

    /**
     * 修改车辆管理基础数据
     * 
     * @param familyCarMangec 车辆管理基础数据
     * @return 结果
     */
    public int updateFamilyCarMangec(FamilyCarMangec familyCarMangec);

    /**
     * 删除车辆管理基础数据
     * 
     * @param id 车辆管理基础数据主键
     * @return 结果
     */
    public int deleteFamilyCarMangecById(Long id);

    /**
     * 批量删除车辆管理基础数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyCarMangecByIds(String[] ids);
}
