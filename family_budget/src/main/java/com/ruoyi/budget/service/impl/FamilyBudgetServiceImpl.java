package com.ruoyi.budget.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.budget.mapper.FamilyBudgetMapper;
import com.ruoyi.budget.domain.FamilyBudget;
import com.ruoyi.budget.service.IFamilyBudgetService;
import com.ruoyi.common.core.text.Convert;

/**
 * 预算Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
@Service
public class FamilyBudgetServiceImpl implements IFamilyBudgetService 
{
    @Autowired
    private FamilyBudgetMapper familyBudgetMapper;

    /**
     * 查询预算
     * 
     * @param familyMemberCode 预算主键
     * @return 预算
     */
    @Override
    public FamilyBudget selectFamilyBudgetByFamilyMemberCode(String familyMemberCode)
    {
        return familyBudgetMapper.selectFamilyBudgetByFamilyMemberCode(familyMemberCode);
    }

    /**
     * 查询预算列表
     * 
     * @param familyBudget 预算
     * @return 预算
     */
    @Override
    public List<FamilyBudget> selectFamilyBudgetList(FamilyBudget familyBudget)
    {
        return familyBudgetMapper.selectFamilyBudgetList(familyBudget);
    }

    /**
     * 新增预算
     * 
     * @param familyBudget 预算
     * @return 结果
     */
    @Override
    public int insertFamilyBudget(FamilyBudget familyBudget)
    {
        return familyBudgetMapper.insertFamilyBudget(familyBudget);
    }

    /**
     * 修改预算
     * 
     * @param familyBudget 预算
     * @return 结果
     */
    @Override
    public int updateFamilyBudget(FamilyBudget familyBudget)
    {
        return familyBudgetMapper.updateFamilyBudget(familyBudget);
    }

    /**
     * 批量删除预算
     * 
     * @param familyMemberCodes 需要删除的预算主键
     * @return 结果
     */
    @Override
    public int deleteFamilyBudgetByFamilyMemberCodes(String familyMemberCodes)
    {
        return familyBudgetMapper.deleteFamilyBudgetByFamilyMemberCodes(Convert.toStrArray(familyMemberCodes));
    }

    /**
     * 删除预算信息
     * 
     * @param familyMemberCode 预算主键
     * @return 结果
     */
    @Override
    public int deleteFamilyBudgetByFamilyMemberCode(String familyMemberCode)
    {
        return familyBudgetMapper.deleteFamilyBudgetByFamilyMemberCode(familyMemberCode);
    }
}
