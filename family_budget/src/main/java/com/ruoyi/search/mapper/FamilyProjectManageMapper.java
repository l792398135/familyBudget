package com.ruoyi.search.mapper;

import java.util.List;
import com.ruoyi.search.domain.FamilyProjectManage;

/**
 * 项目管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
public interface FamilyProjectManageMapper 
{
    /**
     * 查询项目管理
     * 
     * @param id 项目管理主键
     * @return 项目管理
     */
    public FamilyProjectManage selectFamilyProjectManageById(Long id);

    /**
     * 查询项目管理列表
     * 
     * @param familyProjectManage 项目管理
     * @return 项目管理集合
     */
    public List<FamilyProjectManage> selectFamilyProjectManageList(FamilyProjectManage familyProjectManage);

    /**
     * 新增项目管理
     * 
     * @param familyProjectManage 项目管理
     * @return 结果
     */
    public int insertFamilyProjectManage(FamilyProjectManage familyProjectManage);

    /**
     * 修改项目管理
     * 
     * @param familyProjectManage 项目管理
     * @return 结果
     */
    public int updateFamilyProjectManage(FamilyProjectManage familyProjectManage);

    /**
     * 删除项目管理
     * 
     * @param id 项目管理主键
     * @return 结果
     */
    public int deleteFamilyProjectManageById(Long id);

    /**
     * 批量删除项目管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyProjectManageByIds(String[] ids);
}
