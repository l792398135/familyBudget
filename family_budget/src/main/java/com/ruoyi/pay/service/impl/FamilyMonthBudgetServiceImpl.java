package com.ruoyi.pay.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pay.mapper.FamilyMonthBudgetMapper;
import com.ruoyi.pay.domain.FamilyMonthBudget;
import com.ruoyi.pay.service.IFamilyMonthBudgetService;
import com.ruoyi.common.core.text.Convert;

/**
 * 月预算Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-14
 */
@Service
public class FamilyMonthBudgetServiceImpl implements IFamilyMonthBudgetService 
{
    @Autowired
    private FamilyMonthBudgetMapper familyMonthBudgetMapper;

    /**
     * 查询月预算
     * 
     * @param id 月预算主键
     * @return 月预算
     */
    @Override
    public FamilyMonthBudget selectFamilyMonthBudgetById(Long id)
    {
        return familyMonthBudgetMapper.selectFamilyMonthBudgetById(id);
    }

    /**
     * 查询月预算列表
     * 
     * @param familyMonthBudget 月预算
     * @return 月预算
     */
    @Override
    public List<FamilyMonthBudget> selectFamilyMonthBudgetList(FamilyMonthBudget familyMonthBudget)
    {
        return familyMonthBudgetMapper.selectFamilyMonthBudgetList(familyMonthBudget);
    }

    /**
     * 新增月预算
     * 
     * @param familyMonthBudget 月预算
     * @return 结果
     */
    @Override
    public int insertFamilyMonthBudget(FamilyMonthBudget familyMonthBudget)
    {
        return familyMonthBudgetMapper.insertFamilyMonthBudget(familyMonthBudget);
    }

    /**
     * 修改月预算
     * 
     * @param familyMonthBudget 月预算
     * @return 结果
     */
    @Override
    public int updateFamilyMonthBudget(FamilyMonthBudget familyMonthBudget)
    {
        return familyMonthBudgetMapper.updateFamilyMonthBudget(familyMonthBudget);
    }

    /**
     * 批量删除月预算
     * 
     * @param ids 需要删除的月预算主键
     * @return 结果
     */
    @Override
    public int deleteFamilyMonthBudgetByIds(String ids)
    {
        return familyMonthBudgetMapper.deleteFamilyMonthBudgetByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除月预算信息
     * 
     * @param id 月预算主键
     * @return 结果
     */
    @Override
    public int deleteFamilyMonthBudgetById(Long id)
    {
        return familyMonthBudgetMapper.deleteFamilyMonthBudgetById(id);
    }
}
