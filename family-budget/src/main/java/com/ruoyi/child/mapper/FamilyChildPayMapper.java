package com.ruoyi.child.mapper;

import java.util.List;
import com.ruoyi.child.domain.FamilyChildPay;

/**
 * 宝贝支出Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
public interface FamilyChildPayMapper 
{
    /**
     * 查询宝贝支出
     * 
     * @param id 宝贝支出主键
     * @return 宝贝支出
     */
    public FamilyChildPay selectFamilyChildPayById(Long id);

    /**
     * 查询宝贝支出列表
     * 
     * @param familyChildPay 宝贝支出
     * @return 宝贝支出集合
     */
    public List<FamilyChildPay> selectFamilyChildPayList(FamilyChildPay familyChildPay);

    /**
     * 新增宝贝支出
     * 
     * @param familyChildPay 宝贝支出
     * @return 结果
     */
    public int insertFamilyChildPay(FamilyChildPay familyChildPay);

    /**
     * 修改宝贝支出
     * 
     * @param familyChildPay 宝贝支出
     * @return 结果
     */
    public int updateFamilyChildPay(FamilyChildPay familyChildPay);

    /**
     * 删除宝贝支出
     * 
     * @param id 宝贝支出主键
     * @return 结果
     */
    public int deleteFamilyChildPayById(Long id);

    /**
     * 批量删除宝贝支出
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyChildPayByIds(String[] ids);
}
