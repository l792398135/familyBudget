package com.ruoyi.search.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.search.mapper.FamilyAccountMapper;
import com.ruoyi.search.domain.FamilyAccount;
import com.ruoyi.search.service.IFamilyAccountService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 账号管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-15
 */
@Service
public class FamilyAccountServiceImpl implements IFamilyAccountService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyAccountMapper familyAccountMapper;

    /**
     * 查询账号管理
     * 
     * @param id 账号管理主键
     * @return 账号管理
     */
    @Override
    public FamilyAccount selectFamilyAccountById(Long id)
    {
        return familyAccountMapper.selectFamilyAccountById(id);
    }

    /**
     * 查询账号管理列表
     * 
     * @param familyAccount 账号管理
     * @return 账号管理
     */
    @Override
    @DataScope( userAlias = "family_account",deptAlias = "family_account")
    public List<FamilyAccount> selectFamilyAccountList(FamilyAccount familyAccount)
    {
        List<FamilyAccount> familyAccount1= familyAccountMapper.selectFamilyAccountList(familyAccount);
        for (int i = 0; i <familyAccount1.size() ; i++) {
            FamilyAccount item =familyAccount1.get(i);
            Long id = item.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("account");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                item.setImgUrls(collect);
            }
            familyAccount1.set(i,item);
        }
        return familyAccount1;
    }

    /**
     * 新增账号管理
     * 
     * @param familyAccount 账号管理
     * @return 结果
     */
    @Override
    public Long insertFamilyAccount(FamilyAccount familyAccount)
    {
        familyAccount.setUserId(ShiroUtils.getUserId());
        familyAccount.setCreateTime(DateUtils.getNowDate());
        familyAccount.setCreateUser(ShiroUtils.getLoginName());
        familyAccountMapper.insertFamilyAccount(familyAccount);
        return familyAccount.getId();
    }

    /**
     * 修改账号管理
     * 
     * @param familyAccount 账号管理
     * @return 结果
     */
    @Override
    public int updateFamilyAccount(FamilyAccount familyAccount)
    {
        return familyAccountMapper.updateFamilyAccount(familyAccount);
    }

    /**
     * 批量删除账号管理
     * 
     * @param ids 需要删除的账号管理主键
     * @return 结果
     */
    @Override
    public int deleteFamilyAccountByIds(String ids)
    {
        return familyAccountMapper.deleteFamilyAccountByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除账号管理信息
     * 
     * @param id 账号管理主键
     * @return 结果
     */
    @Override
    public int deleteFamilyAccountById(Long id)
    {
        return familyAccountMapper.deleteFamilyAccountById(id);
    }
}
