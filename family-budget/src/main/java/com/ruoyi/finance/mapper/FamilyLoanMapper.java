package com.ruoyi.finance.mapper;

import java.util.List;
import com.ruoyi.finance.domain.FamilyLoan;

/**
 * 负债Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-28
 */
public interface FamilyLoanMapper 
{
    /**
     * 查询负债
     * 
     * @param id 负债主键
     * @return 负债
     */
    public FamilyLoan selectFamilyLoanById(Long id);

    /**
     * 查询负债列表
     * 
     * @param familyLoan 负债
     * @return 负债集合
     */
    public List<FamilyLoan> selectFamilyLoanList(FamilyLoan familyLoan);

    /**
     * 新增负债
     * 
     * @param familyLoan 负债
     * @return 结果
     */
    public int insertFamilyLoan(FamilyLoan familyLoan);

    /**
     * 修改负债
     * 
     * @param familyLoan 负债
     * @return 结果
     */
    public int updateFamilyLoan(FamilyLoan familyLoan);

    /**
     * 删除负债
     * 
     * @param id 负债主键
     * @return 结果
     */
    public int deleteFamilyLoanById(Long id);

    /**
     * 批量删除负债
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyLoanByIds(String[] ids);
}
