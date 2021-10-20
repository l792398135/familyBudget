package com.ruoyi.base.mapper;

import java.util.List;
import com.ruoyi.base.domain.FamilyFeeType;

/**
 * 费用类型Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-19
 */
public interface FamilyFeeTypeMapper 
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
    public int insertFamilyFeeType(FamilyFeeType familyFeeType);

    /**
     * 修改费用类型
     * 
     * @param familyFeeType 费用类型
     * @return 结果
     */
    public int updateFamilyFeeType(FamilyFeeType familyFeeType);

    /**
     * 删除费用类型
     * 
     * @param id 费用类型主键
     * @return 结果
     */
    public int deleteFamilyFeeTypeById(Long id);

    /**
     * 批量删除费用类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyFeeTypeByIds(String[] ids);
}
