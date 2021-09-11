package com.ruoyi.budget.service;

import java.util.List;
import com.ruoyi.budget.domain.FamilyBudget;

/**
 * 预算Service接口
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
public interface IFamilyBudgetService 
{
    /**
     * 查询预算
     * 
     * @param familyMemberCode 预算主键
     * @return 预算
     */
    public FamilyBudget selectFamilyBudgetByFamilyMemberCode(String familyMemberCode);

    /**
     * 查询预算列表
     * 
     * @param familyBudget 预算
     * @return 预算集合
     */
    public List<FamilyBudget> selectFamilyBudgetList(FamilyBudget familyBudget);

    /**
     * 新增预算
     * 
     * @param familyBudget 预算
     * @return 结果
     */
    public int insertFamilyBudget(FamilyBudget familyBudget);

    /**
     * 修改预算
     * 
     * @param familyBudget 预算
     * @return 结果
     */
    public int updateFamilyBudget(FamilyBudget familyBudget);

    /**
     * 批量删除预算
     * 
     * @param familyMemberCodes 需要删除的预算主键集合
     * @return 结果
     */
    public int deleteFamilyBudgetByFamilyMemberCodes(String familyMemberCodes);

    /**
     * 删除预算信息
     * 
     * @param familyMemberCode 预算主键
     * @return 结果
     */
    public int deleteFamilyBudgetByFamilyMemberCode(String familyMemberCode);
}
