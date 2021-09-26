package com.ruoyi.finance.service;

import java.util.List;
import com.ruoyi.finance.domain.FamilyInsuranceReimburse;

/**
 * 保险报销Service接口
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
public interface IFamilyInsuranceReimburseService 
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
     * 批量删除保险报销
     * 
     * @param ids 需要删除的保险报销主键集合
     * @return 结果
     */
    public int deleteFamilyInsuranceReimburseByIds(String ids);

    /**
     * 删除保险报销信息
     * 
     * @param id 保险报销主键
     * @return 结果
     */
    public int deleteFamilyInsuranceReimburseById(Long id);
}
