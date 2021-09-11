package com.ruoyi.pay.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pay.mapper.FamilyIncomeMapper;
import com.ruoyi.pay.domain.FamilyIncome;
import com.ruoyi.pay.service.IFamilyIncomeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 家庭收入Service业务层处理
 * 
 * @author 刘兴武
 * @date 2021-09-10
 */
@Service
public class FamilyIncomeServiceImpl implements IFamilyIncomeService 
{
    @Autowired
    private FamilyIncomeMapper familyIncomeMapper;

    /**
     * 查询家庭收入
     * 
     * @param id 家庭收入主键
     * @return 家庭收入
     */
    @Override
    public FamilyIncome selectFamilyIncomeById(Long id)
    {
        return familyIncomeMapper.selectFamilyIncomeById(id);
    }

    /**
     * 查询家庭收入列表
     * 
     * @param familyIncome 家庭收入
     * @return 家庭收入
     */
    @Override
    public List<FamilyIncome> selectFamilyIncomeList(FamilyIncome familyIncome)
    {
        return familyIncomeMapper.selectFamilyIncomeList(familyIncome);
    }

    /**
     * 新增家庭收入
     * 
     * @param familyIncome 家庭收入
     * @return 结果
     */
    @Override
    public int insertFamilyIncome(FamilyIncome familyIncome)
    {
        return familyIncomeMapper.insertFamilyIncome(familyIncome);
    }

    /**
     * 修改家庭收入
     * 
     * @param familyIncome 家庭收入
     * @return 结果
     */
    @Override
    public int updateFamilyIncome(FamilyIncome familyIncome)
    {
        return familyIncomeMapper.updateFamilyIncome(familyIncome);
    }

    /**
     * 批量删除家庭收入
     * 
     * @param ids 需要删除的家庭收入主键
     * @return 结果
     */
    @Override
    public int deleteFamilyIncomeByIds(String ids)
    {
        return familyIncomeMapper.deleteFamilyIncomeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除家庭收入信息
     * 
     * @param id 家庭收入主键
     * @return 结果
     */
    @Override
    public int deleteFamilyIncomeById(Long id)
    {
        return familyIncomeMapper.deleteFamilyIncomeById(id);
    }
}
