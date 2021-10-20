package com.ruoyi.pay.service;

import java.util.List;
import com.ruoyi.pay.domain.FamilyMonthBudgetDetails;

/**
 * 预算明细Service接口
 * 
 * @author ruoyi
 * @date 2021-10-19
 */
public interface IFamilyMonthBudgetDetailsService 
{
    /**
     * 查询预算明细
     * 
     * @param id 预算明细主键
     * @return 预算明细
     */
    public FamilyMonthBudgetDetails selectFamilyMonthBudgetDetailsById(Long id);

    /**
     * 查询预算明细列表
     * 
     * @param familyMonthBudgetDetails 预算明细
     * @return 预算明细集合
     */
    public List<FamilyMonthBudgetDetails> selectFamilyMonthBudgetDetailsList(FamilyMonthBudgetDetails familyMonthBudgetDetails);

    /**
     * 新增预算明细
     * 
     * @param familyMonthBudgetDetails 预算明细
     * @return 结果
     */
    public Long insertFamilyMonthBudgetDetails(FamilyMonthBudgetDetails familyMonthBudgetDetails);

    /**
     * 修改预算明细
     * 
     * @param familyMonthBudgetDetails 预算明细
     * @return 结果
     */
    public int updateFamilyMonthBudgetDetails(FamilyMonthBudgetDetails familyMonthBudgetDetails);

    /**
     * 批量删除预算明细
     * 
     * @param ids 需要删除的预算明细主键集合
     * @return 结果
     */
    public int deleteFamilyMonthBudgetDetailsByIds(String ids);

    /**
     * 删除预算明细信息
     * 
     * @param id 预算明细主键
     * @return 结果
     */
    public int deleteFamilyMonthBudgetDetailsById(Long id);
}
