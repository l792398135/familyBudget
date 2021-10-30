package com.ruoyi.base.mapper;

import java.util.List;
import com.ruoyi.base.domain.FamilyCarMange;

/**
 * 车辆管理基础数据Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-26
 */
public interface FamilyCarMangeMapper 
{
    /**
     * 查询车辆管理基础数据
     * 
     * @param id 车辆管理基础数据主键
     * @return 车辆管理基础数据
     */
    public FamilyCarMange selectFamilyCarMangeById(Long id);

    /**
     * 查询车辆管理基础数据列表
     * 
     * @param familyCarMange 车辆管理基础数据
     * @return 车辆管理基础数据集合
     */
    public List<FamilyCarMange> selectFamilyCarMangeList(FamilyCarMange familyCarMange);

    /**
     * 新增车辆管理基础数据
     * 
     * @param familyCarMange 车辆管理基础数据
     * @return 结果
     */
    public int insertFamilyCarMange(FamilyCarMange familyCarMange);

    /**
     * 修改车辆管理基础数据
     * 
     * @param familyCarMange 车辆管理基础数据
     * @return 结果
     */
    public int updateFamilyCarMange(FamilyCarMange familyCarMange);

    /**
     * 删除车辆管理基础数据
     * 
     * @param id 车辆管理基础数据主键
     * @return 结果
     */
    public int deleteFamilyCarMangeById(Long id);

    /**
     * 批量删除车辆管理基础数据
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyCarMangeByIds(String[] ids);
}
