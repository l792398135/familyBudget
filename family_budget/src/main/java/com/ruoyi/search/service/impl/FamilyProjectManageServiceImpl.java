package com.ruoyi.search.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.search.mapper.FamilyProjectManageMapper;
import com.ruoyi.search.domain.FamilyProjectManage;
import com.ruoyi.search.service.IFamilyProjectManageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
@Service
public class FamilyProjectManageServiceImpl implements IFamilyProjectManageService 
{
    @Autowired
    private FamilyProjectManageMapper familyProjectManageMapper;

    /**
     * 查询项目管理
     * 
     * @param id 项目管理主键
     * @return 项目管理
     */
    @Override
    public FamilyProjectManage selectFamilyProjectManageById(Long id)
    {
        return familyProjectManageMapper.selectFamilyProjectManageById(id);
    }

    /**
     * 查询项目管理列表
     * 
     * @param familyProjectManage 项目管理
     * @return 项目管理
     */
    @Override
    public List<FamilyProjectManage> selectFamilyProjectManageList(FamilyProjectManage familyProjectManage)
    {
        return familyProjectManageMapper.selectFamilyProjectManageList(familyProjectManage);
    }

    /**
     * 新增项目管理
     * 
     * @param familyProjectManage 项目管理
     * @return 结果
     */
    @Override
    public int insertFamilyProjectManage(FamilyProjectManage familyProjectManage)
    {
        familyProjectManage.setCreateTime(DateUtils.getNowDate());
        return familyProjectManageMapper.insertFamilyProjectManage(familyProjectManage);
    }

    /**
     * 修改项目管理
     * 
     * @param familyProjectManage 项目管理
     * @return 结果
     */
    @Override
    public int updateFamilyProjectManage(FamilyProjectManage familyProjectManage)
    {
        return familyProjectManageMapper.updateFamilyProjectManage(familyProjectManage);
    }

    /**
     * 批量删除项目管理
     * 
     * @param ids 需要删除的项目管理主键
     * @return 结果
     */
    @Override
    public int deleteFamilyProjectManageByIds(String ids)
    {
        return familyProjectManageMapper.deleteFamilyProjectManageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除项目管理信息
     * 
     * @param id 项目管理主键
     * @return 结果
     */
    @Override
    public int deleteFamilyProjectManageById(Long id)
    {
        return familyProjectManageMapper.deleteFamilyProjectManageById(id);
    }
}
