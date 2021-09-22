package com.ruoyi.pay.mapper;

import java.util.List;
import com.ruoyi.pay.domain.FamilyTransferAccount;

/**
 * 转账Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
public interface FamilyTransferAccountMapper 
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
     * 删除转账
     * 
     * @param id 转账主键
     * @return 结果
     */
    public int deleteFamilyTransferAccountById(Long id);

    /**
     * 批量删除转账
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyTransferAccountByIds(String[] ids);
}
