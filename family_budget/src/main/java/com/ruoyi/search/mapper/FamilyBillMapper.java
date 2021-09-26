package com.ruoyi.search.mapper;

import java.util.List;
import com.ruoyi.search.domain.FamilyBill;

/**
 * 单据管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
public interface FamilyBillMapper 
{
    /**
     * 查询单据管理
     * 
     * @param id 单据管理主键
     * @return 单据管理
     */
    public FamilyBill selectFamilyBillById(Long id);

    /**
     * 查询单据管理列表
     * 
     * @param familyBill 单据管理
     * @return 单据管理集合
     */
    public List<FamilyBill> selectFamilyBillList(FamilyBill familyBill);

    /**
     * 新增单据管理
     * 
     * @param familyBill 单据管理
     * @return 结果
     */
    public int insertFamilyBill(FamilyBill familyBill);

    /**
     * 修改单据管理
     * 
     * @param familyBill 单据管理
     * @return 结果
     */
    public int updateFamilyBill(FamilyBill familyBill);

    /**
     * 删除单据管理
     * 
     * @param id 单据管理主键
     * @return 结果
     */
    public int deleteFamilyBillById(Long id);

    /**
     * 批量删除单据管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyBillByIds(String[] ids);
}
