package com.ruoyi.payincome.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.payincome.domain.FamilyMonthBudgetDetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 预算明细Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-19
 */
public interface FamilyMonthBudgetDetailsMapper 
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
    public int insertFamilyMonthBudgetDetails(FamilyMonthBudgetDetails familyMonthBudgetDetails);

    /**
     * 修改预算明细
     * 
     * @param familyMonthBudgetDetails 预算明细
     * @return 结果
     */
    public int updateFamilyMonthBudgetDetails(FamilyMonthBudgetDetails familyMonthBudgetDetails);

    /**
     * 删除预算明细
     * 
     * @param id 预算明细主键
     * @return 结果
     */
    public int deleteFamilyMonthBudgetDetailsById(Long id);

    /**
     * 批量删除预算明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyMonthBudgetDetailsByIds(String[] ids);

    @Select("select sum(budget_amount) from family_month_budget_details where budget_type =#{budgetType} and budget_date =#{budgetDate} and dict_type =#{dictType}")
    BigDecimal sumBudgetBy(@Param("budgetDate") String budgetDate, @Param("budgetType") String budgetType,@Param("dictType")String dictType);
}
