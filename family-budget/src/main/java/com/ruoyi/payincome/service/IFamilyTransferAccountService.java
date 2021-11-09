package com.ruoyi.payincome.service;

import java.util.List;
import com.ruoyi.payincome.domain.FamilyTransferAccount;

/**
 * 转账Service接口
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
public interface IFamilyTransferAccountService 
{
    /**
     * 查询转账
     * 
     * @param id 转账主键
     * @return 转账
     */
    public FamilyTransferAccount selectFamilyTransferAccountById(Long id);

    /**
     * 查询转账列表
     * 
     * @param familyTransferAccount 转账
     * @return 转账集合
     */
    public List<FamilyTransferAccount> selectFamilyTransferAccountList(FamilyTransferAccount familyTransferAccount);

    /**
     * 新增转账
     * 
     * @param familyTransferAccount 转账
     * @return 结果
     */
    public int insertFamilyTransferAccount(FamilyTransferAccount familyTransferAccount);

    /**
     * 修改转账
     * 
     * @param familyTransferAccount 转账
     * @return 结果
     */
    public int updateFamilyTransferAccount(FamilyTransferAccount familyTransferAccount);

    /**
     * 批量删除转账
     * 
     * @param ids 需要删除的转账主键集合
     * @return 结果
     */
    public int deleteFamilyTransferAccountByIds(String ids);

    /**
     * 删除转账信息
     * 
     * @param id 转账主键
     * @return 结果
     */
    public int deleteFamilyTransferAccountById(Long id);
}
