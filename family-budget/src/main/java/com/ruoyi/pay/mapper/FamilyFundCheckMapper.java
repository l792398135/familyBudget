package com.ruoyi.pay.mapper;

import java.util.List;
import com.ruoyi.pay.domain.FamilyFundCheck;

/**
 * 盘点Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
public interface FamilyFundCheckMapper 
{
    /**
     * 查询盘点
     * 
     * @param id 盘点主键
     * @return 盘点
     */
    public FamilyFundCheck selectFamilyFundCheckById(Long id);

    /**
     * 查询盘点列表
     * 
     * @param familyFundCheck 盘点
     * @return 盘点集合
     */
    public List<FamilyFundCheck> selectFamilyFundCheckList(FamilyFundCheck familyFundCheck);

    /**
     * 新增盘点
     * 
     * @param familyFundCheck 盘点
     * @return 结果
     */
    public int insertFamilyFundCheck(FamilyFundCheck familyFundCheck);

    /**
     * 修改盘点
     * 
     * @param familyFundCheck 盘点
     * @return 结果
     */
    public int updateFamilyFundCheck(FamilyFundCheck familyFundCheck);

    /**
     * 删除盘点
     * 
     * @param id 盘点主键
     * @return 结果
     */
    public int deleteFamilyFundCheckById(Long id);

    /**
     * 批量删除盘点
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyFundCheckByIds(String[] ids);
}
