package com.ruoyi.finance.mapper;

import java.util.List;
import com.ruoyi.finance.domain.FamilyDebt;

/**
 * 债务Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-25
 */
public interface FamilyDebtMapper 
{
    /**
     * 查询债务
     * 
     * @param id 债务主键
     * @return 债务
     */
    public FamilyDebt selectFamilyDebtById(Long id);

    /**
     * 查询债务列表
     * 
     * @param familyDebt 债务
     * @return 债务集合
     */
    public List<FamilyDebt> selectFamilyDebtList(FamilyDebt familyDebt);

    /**
     * 新增债务
     * 
     * @param familyDebt 债务
     * @return 结果
     */
    public int insertFamilyDebt(FamilyDebt familyDebt);

    /**
     * 修改债务
     * 
     * @param familyDebt 债务
     * @return 结果
     */
    public int updateFamilyDebt(FamilyDebt familyDebt);

    /**
     * 删除债务
     * 
     * @param id 债务主键
     * @return 结果
     */
    public int deleteFamilyDebtById(Long id);

    /**
     * 批量删除债务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyDebtByIds(String[] ids);
}
