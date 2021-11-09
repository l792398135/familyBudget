package com.ruoyi.fixedasset.mapper;

import java.util.List;
import com.ruoyi.fixedasset.domain.FamilyAccount;

/**
 * 账号管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-15
 */
public interface FamilyAccountMapper 
{
    /**
     * 查询账号管理
     * 
     * @param id 账号管理主键
     * @return 账号管理
     */
    public FamilyAccount selectFamilyAccountById(Long id);

    /**
     * 查询账号管理列表
     * 
     * @param familyAccount 账号管理
     * @return 账号管理集合
     */
    public List<FamilyAccount> selectFamilyAccountList(FamilyAccount familyAccount);

    /**
     * 新增账号管理
     * 
     * @param familyAccount 账号管理
     * @return 结果
     */
    public int insertFamilyAccount(FamilyAccount familyAccount);

    /**
     * 修改账号管理
     * 
     * @param familyAccount 账号管理
     * @return 结果
     */
    public int updateFamilyAccount(FamilyAccount familyAccount);

    /**
     * 删除账号管理
     * 
     * @param id 账号管理主键
     * @return 结果
     */
    public int deleteFamilyAccountById(Long id);

    /**
     * 批量删除账号管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyAccountByIds(String[] ids);
}
