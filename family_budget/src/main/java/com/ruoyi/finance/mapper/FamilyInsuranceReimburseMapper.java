package com.ruoyi.finance.mapper;

import java.util.List;
import com.ruoyi.finance.domain.FamilyInsuranceReimburse;

/**
 * 保险报销Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
public interface FamilyInsuranceReimburseMapper 
{
    /**
     * 查询保险报销
     * 
     * @param id 保险报销主键
     * @return 保险报销
     */
    public FamilyInsuranceReimburse selectFamilyInsuranceReimburseById(Long id);

    /**
     * 查询保险报销列表
     * 
     * @param familyInsuranceReimburse 保险报销
     * @return 保险报销集合
     */
    public List<FamilyInsuranceReimburse> selectFamilyInsuranceReimburseList(FamilyInsuranceReimburse familyInsuranceReimburse);

    /**
     * 新增保险报销
     * 
     * @param familyInsuranceReimburse 保险报销
     * @return 结果
     */
    public int insertFamilyInsuranceReimburse(FamilyInsuranceReimburse familyInsuranceReimburse);

    /**
     * 修改保险报销
     * 
     * @param familyInsuranceReimburse 保险报销
     * @return 结果
     */
    public int updateFamilyInsuranceReimburse(FamilyInsuranceReimburse familyInsuranceReimburse);

    /**
     * 删除保险报销
     * 
     * @param id 保险报销主键
     * @return 结果
     */
    public int deleteFamilyInsuranceReimburseById(Long id);

    /**
     * 批量删除保险报销
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyInsuranceReimburseByIds(String[] ids);
}
