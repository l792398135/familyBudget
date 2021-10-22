package com.ruoyi.pay.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pay.mapper.FamilyTransferAccountMapper;
import com.ruoyi.pay.domain.FamilyTransferAccount;
import com.ruoyi.pay.service.IFamilyTransferAccountService;
import com.ruoyi.common.core.text.Convert;

/**
 * 转账Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
@Service
public class FamilyTransferAccountServiceImpl implements IFamilyTransferAccountService 
{
    @Autowired
    private FamilyTransferAccountMapper familyTransferAccountMapper;

    /**
     * 查询转账
     * 
     * @param id 转账主键
     * @return 转账
     */
    @Override
    public FamilyTransferAccount selectFamilyTransferAccountById(Long id)
    {
        return familyTransferAccountMapper.selectFamilyTransferAccountById(id);
    }

    /**
     * 查询转账列表
     * 
     * @param familyTransferAccount 转账
     * @return 转账
     */
    @Override
    public List<FamilyTransferAccount> selectFamilyTransferAccountList(FamilyTransferAccount familyTransferAccount)
    {
        return familyTransferAccountMapper.selectFamilyTransferAccountList(familyTransferAccount);
    }

    /**
     * 新增转账
     * 
     * @param familyTransferAccount 转账
     * @return 结果
     */
    @Override
    public int insertFamilyTransferAccount(FamilyTransferAccount familyTransferAccount)
    {
        familyTransferAccount.setCreateTime(DateUtils.getNowDate());
        familyTransferAccount.setCreateUser(ShiroUtils.getLoginName());
        return familyTransferAccountMapper.insertFamilyTransferAccount(familyTransferAccount);
    }

    /**
     * 修改转账
     * 
     * @param familyTransferAccount 转账
     * @return 结果
     */
    @Override
    public int updateFamilyTransferAccount(FamilyTransferAccount familyTransferAccount)
    {
        return familyTransferAccountMapper.updateFamilyTransferAccount(familyTransferAccount);
    }

    /**
     * 批量删除转账
     * 
     * @param ids 需要删除的转账主键
     * @return 结果
     */
    @Override
    public int deleteFamilyTransferAccountByIds(String ids)
    {
        return familyTransferAccountMapper.deleteFamilyTransferAccountByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除转账信息
     * 
     * @param id 转账主键
     * @return 结果
     */
    @Override
    public int deleteFamilyTransferAccountById(Long id)
    {
        return familyTransferAccountMapper.deleteFamilyTransferAccountById(id);
    }
}
