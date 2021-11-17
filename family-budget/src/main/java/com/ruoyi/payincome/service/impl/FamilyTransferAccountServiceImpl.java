package com.ruoyi.payincome.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.payincome.domain.FamilyPay;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.payincome.mapper.FamilyTransferAccountMapper;
import com.ruoyi.payincome.domain.FamilyTransferAccount;
import com.ruoyi.payincome.service.IFamilyTransferAccountService;
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
        FamilyTransferAccount familyTransferAccount1 = familyTransferAccountMapper.selectFamilyTransferAccountById(familyTransferAccount.getId());
        dataOverProtect(familyTransferAccount1);
        return familyTransferAccountMapper.updateFamilyTransferAccount(familyTransferAccount);
    }

    private void dataOverProtect(FamilyTransferAccount familyPay) {
        Date createDate = familyPay.getCreateTime();
        if (DateUtils.differentDaysByMillisecond(new Date(), createDate) > 3) {
            throw new BusinessException("创建时间已过3天,不允许操作");
        }
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
        String[] strings = Convert.toStrArray(ids);
        for (String string : strings) {
            FamilyTransferAccount familyTransferAccount1 = familyTransferAccountMapper.selectFamilyTransferAccountById(Long.valueOf(string));
            dataOverProtect(familyTransferAccount1);
            Long businessId = familyTransferAccount1.getBusinessId();
            if (!ObjectUtils.isEmpty(businessId)){
                throw new BusinessException("其他操作生成的记录，不允许此处修改！");
            }
            familyTransferAccountMapper.deleteFamilyTransferAccountById(Long.valueOf(string));
        }
        return 1;
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
