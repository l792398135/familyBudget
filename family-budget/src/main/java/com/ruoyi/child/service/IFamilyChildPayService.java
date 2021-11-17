package com.ruoyi.child.service;

import java.util.List;
import com.ruoyi.child.domain.FamilyChildPay;

/**
 * 宝贝支出Service接口
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
public interface IFamilyChildPayService 
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
    public Long insertFamilyChildPay(FamilyChildPay familyChildPay);

    /**
     * 修改宝贝支出
     * 
     * @param familyChildPay 宝贝支出
     * @return 结果
     */
    public int updateFamilyChildPay(FamilyChildPay familyChildPay);

    /**
     * 批量删除宝贝支出
     * 
     * @param ids 需要删除的宝贝支出主键集合
     * @return 结果
     */
    public int deleteFamilyChildPayByIds(String ids);

    /**
     * 删除宝贝支出信息
     * 
     * @param id 宝贝支出主键
     * @return 结果
     */
    public int deleteFamilyChildPayById(Long id);
}
