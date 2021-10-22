package com.ruoyi.finance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.finance.mapper.FamilyDebtMapper;
import com.ruoyi.finance.domain.FamilyDebt;
import com.ruoyi.finance.service.IFamilyDebtService;
import com.ruoyi.common.core.text.Convert;

/**
 * 债务Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-25
 */
@Service
public class FamilyDebtServiceImpl implements IFamilyDebtService 
{
    @Autowired
    private FamilyDebtMapper familyDebtMapper;

    /**
     * 查询债务
     * 
     * @param id 债务主键
     * @return 债务
     */
    @Override
    public FamilyDebt selectFamilyDebtById(Long id)
    {
        return familyDebtMapper.selectFamilyDebtById(id);
    }

    /**
     * 查询债务列表
     * 
     * @param familyDebt 债务
     * @return 债务
     */
    @Override
    public List<FamilyDebt> selectFamilyDebtList(FamilyDebt familyDebt)
    {
        return familyDebtMapper.selectFamilyDebtList(familyDebt);
    }

    /**
     * 新增债务
     * 
     * @param familyDebt 债务
     * @return 结果
     */
    @Override
    public int insertFamilyDebt(FamilyDebt familyDebt)
    {
        return familyDebtMapper.insertFamilyDebt(familyDebt);
    }

    /**
     * 修改债务
     * 
     * @param familyDebt 债务
     * @return 结果
     */
    @Override
    public int updateFamilyDebt(FamilyDebt familyDebt)
    {
        return familyDebtMapper.updateFamilyDebt(familyDebt);
    }

    /**
     * 批量删除债务
     * 
     * @param ids 需要删除的债务主键
     * @return 结果
     */
    @Override
    public int deleteFamilyDebtByIds(String ids)
    {
        return familyDebtMapper.deleteFamilyDebtByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除债务信息
     * 
     * @param id 债务主键
     * @return 结果
     */
    @Override
    public int deleteFamilyDebtById(Long id)
    {
        return familyDebtMapper.deleteFamilyDebtById(id);
    }
}
