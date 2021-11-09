package com.ruoyi.payincome.mapper;

import java.util.List;
import com.ruoyi.payincome.domain.FamilyPay;

/**
 * 费用支出Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
public interface FamilyPayMapper 
{
    /**
     * 查询费用支出
     * 
     * @param id 费用支出主键
     * @return 费用支出
     */
    public FamilyPay selectFamilyPayById(Long id);

    /**
     * 查询费用支出列表
     * 
     * @param familyPay 费用支出
     * @return 费用支出集合
     */
    public List<FamilyPay> selectFamilyPayList(FamilyPay familyPay);

    /**
     * 新增费用支出
     * 
     * @param familyPay 费用支出
     * @return 结果
     */
    public int insertFamilyPay(FamilyPay familyPay);

    /**
     * 修改费用支出
     * 
     * @param familyPay 费用支出
     * @return 结果
     */
    public int updateFamilyPay(FamilyPay familyPay);

    /**
     * 删除费用支出
     * 
     * @param id 费用支出主键
     * @return 结果
     */
    public int deleteFamilyPayById(Long id);

    /**
     * 批量删除费用支出
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyPayByIds(String[] ids);
}
