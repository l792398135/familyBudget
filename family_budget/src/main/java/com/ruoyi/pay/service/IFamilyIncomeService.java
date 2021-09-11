package com.ruoyi.pay.service;

import java.util.List;
import com.ruoyi.pay.domain.FamilyIncome;

/**
 * 家庭收入Service接口
 * 
 * @author 刘兴武
 * @date 2021-09-10
 */
public interface IFamilyIncomeService 
{
    /**
     * 查询家庭收入
     * 
     * @param id 家庭收入主键
     * @return 家庭收入
     */
    public FamilyIncome selectFamilyIncomeById(Long id);

    /**
     * 查询家庭收入列表
     * 
     * @param familyIncome 家庭收入
     * @return 家庭收入集合
     */
    public List<FamilyIncome> selectFamilyIncomeList(FamilyIncome familyIncome);

    /**
     * 新增家庭收入
     * 
     * @param familyIncome 家庭收入
     * @return 结果
     */
    public int insertFamilyIncome(FamilyIncome familyIncome);

    /**
     * 修改家庭收入
     * 
     * @param familyIncome 家庭收入
     * @return 结果
     */
    public int updateFamilyIncome(FamilyIncome familyIncome);

    /**
     * 批量删除家庭收入
     * 
     * @param ids 需要删除的家庭收入主键集合
     * @return 结果
     */
    public int deleteFamilyIncomeByIds(String ids);

    /**
     * 删除家庭收入信息
     * 
     * @param id 家庭收入主键
     * @return 结果
     */
    public int deleteFamilyIncomeById(Long id);
}
