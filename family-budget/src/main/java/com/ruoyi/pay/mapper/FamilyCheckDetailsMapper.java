package com.ruoyi.pay.mapper;

import java.util.List;
import com.ruoyi.pay.domain.FamilyCheckDetails;

/**
 * 盘点详情Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-23
 */
public interface FamilyCheckDetailsMapper 
{
    /**
     * 查询盘点详情
     * 
     * @param id 盘点详情主键
     * @return 盘点详情
     */
    public FamilyCheckDetails selectFamilyCheckDetailsById(Long id);

    /**
     * 查询盘点详情列表
     * 
     * @param familyCheckDetails 盘点详情
     * @return 盘点详情集合
     */
    public List<FamilyCheckDetails> selectFamilyCheckDetailsList(FamilyCheckDetails familyCheckDetails);

    /**
     * 新增盘点详情
     * 
     * @param familyCheckDetails 盘点详情
     * @return 结果
     */
    public int insertFamilyCheckDetails(FamilyCheckDetails familyCheckDetails);

    /**
     * 修改盘点详情
     * 
     * @param familyCheckDetails 盘点详情
     * @return 结果
     */
    public int updateFamilyCheckDetails(FamilyCheckDetails familyCheckDetails);

    /**
     * 删除盘点详情
     * 
     * @param id 盘点详情主键
     * @return 结果
     */
    public int deleteFamilyCheckDetailsById(Long id);

    /**
     * 批量删除盘点详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyCheckDetailsByIds(String[] ids);
}
