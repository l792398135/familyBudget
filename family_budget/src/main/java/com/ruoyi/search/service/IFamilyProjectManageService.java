package com.ruoyi.search.service;

import java.util.List;
import com.ruoyi.search.domain.FamilyProjectManage;

/**
 * 项目管理Service接口
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
public interface IFamilyProjectManageService 
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
    public Long insertFamilyProjectManage(FamilyProjectManage familyProjectManage);

    /**
     * 修改项目管理
     * 
     * @param familyProjectManage 项目管理
     * @return 结果
     */
    public int updateFamilyProjectManage(FamilyProjectManage familyProjectManage);

    /**
     * 批量删除项目管理
     * 
     * @param ids 需要删除的项目管理主键集合
     * @return 结果
     */
    public int deleteFamilyProjectManageByIds(String ids);

    /**
     * 删除项目管理信息
     * 
     * @param id 项目管理主键
     * @return 结果
     */
    public int deleteFamilyProjectManageById(Long id);
}
