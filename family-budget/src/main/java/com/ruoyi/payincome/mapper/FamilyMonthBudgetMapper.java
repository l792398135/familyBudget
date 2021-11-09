package com.ruoyi.payincome.mapper;

import java.util.List;
import com.ruoyi.payincome.domain.FamilyMonthBudget;

/**
 * 月预算Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-14
 */
public interface FamilyMonthBudgetMapper 
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
     * 删除月预算
     * 
     * @param id 月预算主键
     * @return 结果
     */
    public int deleteFamilyMonthBudgetById(Long id);

    /**
     * 批量删除月预算
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyMonthBudgetByIds(String[] ids);
}
