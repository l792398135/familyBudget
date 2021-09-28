package com.ruoyi.finance.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.finance.mapper.FamilyLoanMapper;
import com.ruoyi.finance.domain.FamilyLoan;
import com.ruoyi.finance.service.IFamilyLoanService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 负债Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-28
 */
@Service
public class FamilyLoanServiceImpl implements IFamilyLoanService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyLoanMapper familyLoanMapper;

    /**
     * 查询负债
     * 
     * @param id 负债主键
     * @return 负债
     */
    @Override
    public FamilyLoan selectFamilyLoanById(Long id)
    {
        return familyLoanMapper.selectFamilyLoanById(id);
    }

    /**
     * 查询负债列表
     * 
     * @param familyLoan 负债
     * @return 负债
     */
    @Override
    public List<FamilyLoan> selectFamilyLoanList(FamilyLoan familyLoan)
    {
        List<FamilyLoan> familyLoan1= familyLoanMapper.selectFamilyLoanList(familyLoan);
        for (int i = 0; i <familyLoan1.size() ; i++) {
            FamilyLoan item =familyLoan1.get(i);
            Long id = item.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("loan");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                item.setImgUrls(collect);
            }
            familyLoan1.set(i,item);
        }
        return familyLoan1;
    }

    /**
     * 新增负债
     * 
     * @param familyLoan 负债
     * @return 结果
     */
    @Override
    public Long insertFamilyLoan(FamilyLoan familyLoan)
    {
        familyLoan.setCreateTime(DateUtils.getNowDate());
        familyLoan.setCreateUser(ShiroUtils.getLoginName());
        familyLoanMapper.insertFamilyLoan(familyLoan);
        return familyLoan.getId();
    }

    /**
     * 修改负债
     * 
     * @param familyLoan 负债
     * @return 结果
     */
    @Override
    public int updateFamilyLoan(FamilyLoan familyLoan)
    {
        return familyLoanMapper.updateFamilyLoan(familyLoan);
    }

    /**
     * 批量删除负债
     * 
     * @param ids 需要删除的负债主键
     * @return 结果
     */
    @Override
    public int deleteFamilyLoanByIds(String ids)
    {
        return familyLoanMapper.deleteFamilyLoanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除负债信息
     * 
     * @param id 负债主键
     * @return 结果
     */
    @Override
    public int deleteFamilyLoanById(Long id)
    {
        return familyLoanMapper.deleteFamilyLoanById(id);
    }
}
