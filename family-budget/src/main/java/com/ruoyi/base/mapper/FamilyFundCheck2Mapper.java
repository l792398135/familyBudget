package com.ruoyi.base.mapper;

import java.util.List;
import com.ruoyi.base.domain.FamilyFundCheck2;

/**
 * 盘点设置Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-26
 */
public interface FamilyFundCheck2Mapper
{
    /**
     * 查询盘点设置
     * 
     * @param id 盘点设置主键
     * @return 盘点设置
     */
    public FamilyFundCheck2 selectFamilyFundCheckById(Long id);

    /**
     * 查询盘点设置列表
     * 
     * @param familyFundCheck2 盘点设置
     * @return 盘点设置集合
     */
    public List<FamilyFundCheck2> selectFamilyFundCheckList(FamilyFundCheck2 familyFundCheck2);

    /**
     * 新增盘点设置
     * 
     * @param familyFundCheck2 盘点设置
     * @return 结果
     */
    public int insertFamilyFundCheck(FamilyFundCheck2 familyFundCheck2);

    /**
     * 修改盘点设置
     * 
     * @param familyFundCheck2 盘点设置
     * @return 结果
     */
    public int updateFamilyFundCheck(FamilyFundCheck2 familyFundCheck2);

    /**
     * 删除盘点设置
     * 
     * @param id 盘点设置主键
     * @return 结果
     */
    public int deleteFamilyFundCheckById(Long id);

    /**
     * 批量删除盘点设置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyFundCheckByIds(String[] ids);
}
