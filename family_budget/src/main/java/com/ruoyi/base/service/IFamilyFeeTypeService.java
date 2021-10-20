package com.ruoyi.base.service;

import java.util.List;
import com.ruoyi.base.domain.FamilyFeeType;

/**
 * 费用类型Service接口
 * 
 * @author ruoyi
 * @date 2021-10-19
 */
public interface IFamilyFeeTypeService 
{
    /**
     * 查询费用类型
     * 
     * @param id 费用类型主键
     * @return 费用类型
     */
    public FamilyFeeType selectFamilyFeeTypeById(Long id);

    /**
     * 查询费用类型列表
     * 
     * @param familyFeeType 费用类型
     * @return 费用类型集合
     */
    public List<FamilyFeeType> selectFamilyFeeTypeList(FamilyFeeType familyFeeType);

    /**
     * 新增费用类型
     * 
     * @param familyFeeType 费用类型
     * @return 结果
     */
    public Long insertFamilyFeeType(FamilyFeeType familyFeeType);

    /**
     * 修改费用类型
     * 
     * @param familyFeeType 费用类型
     * @return 结果
     */
    public int updateFamilyFeeType(FamilyFeeType familyFeeType);

    /**
     * 批量删除费用类型
     * 
     * @param ids 需要删除的费用类型主键集合
     * @return 结果
     */
    public int deleteFamilyFeeTypeByIds(String ids);

    /**
     * 删除费用类型信息
     * 
     * @param id 费用类型主键
     * @return 结果
     */
    public int deleteFamilyFeeTypeById(Long id);

    void refresh();
}
