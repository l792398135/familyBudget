package com.ruoyi.finance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.finance.mapper.FamilyInsuranceReimburseMapper;
import com.ruoyi.finance.domain.FamilyInsuranceReimburse;
import com.ruoyi.finance.service.IFamilyInsuranceReimburseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 保险报销Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
@Service
public class FamilyInsuranceReimburseServiceImpl implements IFamilyInsuranceReimburseService 
{
    @Autowired
    private FamilyInsuranceReimburseMapper familyInsuranceReimburseMapper;

    /**
     * 查询保险报销
     * 
     * @param id 保险报销主键
     * @return 保险报销
     */
    @Override
    public FamilyInsuranceReimburse selectFamilyInsuranceReimburseById(Long id)
    {
        return familyInsuranceReimburseMapper.selectFamilyInsuranceReimburseById(id);
    }

    /**
     * 查询保险报销列表
     * 
     * @param familyInsuranceReimburse 保险报销
     * @return 保险报销
     */
    @Override
    public List<FamilyInsuranceReimburse> selectFamilyInsuranceReimburseList(FamilyInsuranceReimburse familyInsuranceReimburse)
    {
        return familyInsuranceReimburseMapper.selectFamilyInsuranceReimburseList(familyInsuranceReimburse);
    }

    /**
     * 新增保险报销
     * 
     * @param familyInsuranceReimburse 保险报销
     * @return 结果
     */
    @Override
    public int insertFamilyInsuranceReimburse(FamilyInsuranceReimburse familyInsuranceReimburse)
    {
        return familyInsuranceReimburseMapper.insertFamilyInsuranceReimburse(familyInsuranceReimburse);
    }

    /**
     * 修改保险报销
     * 
     * @param familyInsuranceReimburse 保险报销
     * @return 结果
     */
    @Override
    public int updateFamilyInsuranceReimburse(FamilyInsuranceReimburse familyInsuranceReimburse)
    {
        return familyInsuranceReimburseMapper.updateFamilyInsuranceReimburse(familyInsuranceReimburse);
    }

    /**
     * 批量删除保险报销
     * 
     * @param ids 需要删除的保险报销主键
     * @return 结果
     */
    @Override
    public int deleteFamilyInsuranceReimburseByIds(String ids)
    {
        return familyInsuranceReimburseMapper.deleteFamilyInsuranceReimburseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除保险报销信息
     * 
     * @param id 保险报销主键
     * @return 结果
     */
    @Override
    public int deleteFamilyInsuranceReimburseById(Long id)
    {
        return familyInsuranceReimburseMapper.deleteFamilyInsuranceReimburseById(id);
    }
}
