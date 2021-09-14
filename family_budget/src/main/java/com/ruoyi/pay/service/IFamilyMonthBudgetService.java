package com.ruoyi.pay.service;

import java.util.List;
import com.ruoyi.pay.domain.FamilyMonthBudget;

/**
 * 月预算Service接口
 * 
 * @author ruoyi
 * @date 2021-09-14
 */
public interface IFamilyMonthBudgetService 
{
    /**
     * 查询月预算
     * 
     * @param id 月预算主键
     * @return 月预算
     */
    public FamilyMonthBudget selectFamilyMonthBudgetById(Long id);

    /**
     * 查询月预算列表
     * 
     * @param familyMonthBudget 月预算
     * @return 月预算集合
     */
    public List<FamilyMonthBudget> selectFamilyMonthBudgetList(FamilyMonthBudget familyMonthBudget);

    /**
     * 新增月预算
     * 
     * @param familyMonthBudget 月预算
     * @return 结果
     */
    public int insertFamilyMonthBudget(FamilyMonthBudget familyMonthBudget);

    /**
     * 修改月预算
     * 
     * @param familyMonthBudget 月预算
     * @return 结果
     */
    public int updateFamilyMonthBudget(FamilyMonthBudget familyMonthBudget);

    /**
     * 批量删除月预算
     * 
     * @param ids 需要删除的月预算主键集合
     * @return 结果
     */
    public int deleteFamilyMonthBudgetByIds(String ids);

    /**
     * 删除月预算信息
     * 
     * @param id 月预算主键
     * @return 结果
     */
    public int deleteFamilyMonthBudgetById(Long id);
}
