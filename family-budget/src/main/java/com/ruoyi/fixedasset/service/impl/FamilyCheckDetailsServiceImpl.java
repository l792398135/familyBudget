package com.ruoyi.fixedasset.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.fixedasset.domain.FamilyFundCheck;
import com.ruoyi.fixedasset.service.IFamilyFundCheckService;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fixedasset.mapper.FamilyCheckDetailsMapper;
import com.ruoyi.fixedasset.domain.FamilyCheckDetails;
import com.ruoyi.fixedasset.service.IFamilyCheckDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 盘点详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-23
 */
@Service
public class FamilyCheckDetailsServiceImpl implements IFamilyCheckDetailsService 
{
    @Autowired
    private FamilyCheckDetailsMapper familyCheckDetailsMapper;

    @Autowired
    private IFamilyFundCheckService familyFundCheckService;
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;
    /**
     * 查询盘点详情
     * 
     * @param id 盘点详情主键
     * @return 盘点详情
     */
    @Override
    public FamilyCheckDetails selectFamilyCheckDetailsById(Long id)
    {
        return familyCheckDetailsMapper.selectFamilyCheckDetailsById(id);
    }

    /**
     * 查询盘点详情列表
     * 
     * @param familyCheckDetails 盘点详情
     * @return 盘点详情
     */
    @Override
    public List<FamilyCheckDetails> selectFamilyCheckDetailsList(FamilyCheckDetails familyCheckDetails)
    {
        List<FamilyCheckDetails> familyCheckDetails1 = familyCheckDetailsMapper.selectFamilyCheckDetailsList(familyCheckDetails);
        for (int i = 0; i <familyCheckDetails1.size() ; i++) {
            FamilyCheckDetails familyCheckDetails2 = familyCheckDetails1.get(i);
            Long id = familyCheckDetails2.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("checkdetails");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                familyCheckDetails2.setImgUrls(collect);
            }
            familyCheckDetails1.set(i,familyCheckDetails2);
        }
        return familyCheckDetails1;
    }

    /**
     * 新增盘点详情
     * 
     * @param familyCheckDetails 盘点详情
     * @return 结果
     */
    @Override
    public Long insertFamilyCheckDetails(FamilyCheckDetails familyCheckDetails)
    {
        FamilyFundCheck familyFundCheck = new FamilyFundCheck();
        familyFundCheck.setCheckCode(familyCheckDetails.getCheckCode());
        List<FamilyFundCheck> familyFundChecks = familyFundCheckService.selectFamilyFundCheckList(familyFundCheck);
        if (familyFundChecks.size()>0){
            String lockFlag = familyFundChecks.get(0).getLockFlag();
            if ("Y".equals(lockFlag)){
                throw new BusinessException("这个盘点已经锁定,不可修改,删除,新增！");
            }
        }
        familyCheckDetails.setCreateTime(DateUtils.getNowDate());
        familyCheckDetails.setCreateUser(ShiroUtils.getLoginName());
        int i = familyCheckDetailsMapper.insertFamilyCheckDetails(familyCheckDetails);
        return familyCheckDetails.getId();
    }

    /**
     * 修改盘点详情
     * 
     * @param familyCheckDetails 盘点详情
     * @return 结果
     */
    @Override
    public int updateFamilyCheckDetails(FamilyCheckDetails familyCheckDetails)
    {
        FamilyFundCheck familyFundCheck = new FamilyFundCheck();
        familyFundCheck.setCheckCode(familyCheckDetails.getCheckCode());
        List<FamilyFundCheck> familyFundChecks = familyFundCheckService.selectFamilyFundCheckList(familyFundCheck);
        if (familyFundChecks.size()>0){
            String lockFlag = familyFundChecks.get(0).getLockFlag();
            if ("Y".equals(lockFlag)){
                throw new BusinessException("这个盘点已经锁定,不可修改,删除,新增！");
            }
        }
        return familyCheckDetailsMapper.updateFamilyCheckDetails(familyCheckDetails);
    }

    /**
     * 批量删除盘点详情
     * 
     * @param ids 需要删除的盘点详情主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCheckDetailsByIds(String ids)
    {

        String[] strings = Convert.toStrArray(ids);
        for (String string : strings) {
            FamilyCheckDetails familyCheckDetails = familyCheckDetailsMapper.selectFamilyCheckDetailsById(Long.valueOf(string));
            FamilyFundCheck familyFundCheck = new FamilyFundCheck();
            familyFundCheck.setCheckCode(familyCheckDetails.getCheckCode());
            List<FamilyFundCheck> familyFundChecks = familyFundCheckService.selectFamilyFundCheckList(familyFundCheck);
            if (familyFundChecks.size()>0){
                String lockFlag = familyFundChecks.get(0).getLockFlag();
                if ("Y".equals(lockFlag)){
                    throw new BusinessException("这个盘点已经锁定,不可修改,删除,新增！");
                }
            }
        }
        return familyCheckDetailsMapper.deleteFamilyCheckDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除盘点详情信息
     * 
     * @param id 盘点详情主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCheckDetailsById(Long id)
    {
        return familyCheckDetailsMapper.deleteFamilyCheckDetailsById(id);
    }
}
