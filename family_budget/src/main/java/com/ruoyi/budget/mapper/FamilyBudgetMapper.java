package com.ruoyi.budget.mapper;

import java.util.List;
import com.ruoyi.budget.domain.FamilyBudget;

/**
 * 预算Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
public interface FamilyBudgetMapper 
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
     * 删除预算
     * 
     * @param familyMemberCode 预算主键
     * @return 结果
     */
    public int deleteFamilyBudgetByFamilyMemberCode(String familyMemberCode);

    /**
     * 批量删除预算
     * 
     * @param familyMemberCodes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyBudgetByFamilyMemberCodes(String[] familyMemberCodes);
}
