package com.ruoyi.child.service.impl;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.ShiroUtils;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.payincome.domain.FamilyIncome;
import com.ruoyi.payincome.domain.FamilyTransferAccount;
import com.ruoyi.payincome.mapper.FamilyTransferAccountMapper;
import com.ruoyi.system.mapper.SysDictDataMapper;
import com.ruoyi.system.service.ISysConfigService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.child.mapper.FamilyChildFundAgentMapper;
import com.ruoyi.child.domain.FamilyChildFundAgent;
import com.ruoyi.child.service.IFamilyChildFundAgentService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.mapper.SysAttachmentMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 资金代管Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
@Service
public class FamilyChildFundAgentServiceImpl implements IFamilyChildFundAgentService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyChildFundAgentMapper childFundAgentMapper;

    @Autowired
    private FamilyTransferAccountMapper transferAccountMapper;

    @Autowired
    private SysDictDataMapper dictDataMapper;
    /**
     * 查询资金代管
     * 
     * @param id 资金代管主键
     * @return 资金代管
     */
    @Override
    public FamilyChildFundAgent selectFamilyChildFundAgentById(Long id)
    {
        return childFundAgentMapper.selectFamilyChildFundAgentById(id);
    }

    /**
     * 查询资金代管列表
     * 
     * @param familyChildFundAgent 资金代管
     * @return 资金代管
     */
    @Override
    public List<FamilyChildFundAgent> selectFamilyChildFundAgentList(FamilyChildFundAgent familyChildFundAgent)
    {
        List<FamilyChildFundAgent> familyChildFundAgent1= childFundAgentMapper.selectFamilyChildFundAgentList(familyChildFundAgent);
        return familyChildFundAgent1;
    }

    /**
     * 新增资金代管
     * 
     * @param childFundAgent 资金代管
     * @return 结果
     */
    @Override
    @Transactional
    public Long insertFamilyChildFundAgent(FamilyChildFundAgent childFundAgent)
    {
        childFundAgent.setCreateTime(DateUtils.getNowDate());
        childFundAgent.setCreateUser(ShiroUtils.getLoginName());
        childFundAgentMapper.insertFamilyChildFundAgent(childFundAgent);
        //如果代管人和出资人不一致
        String moneyAgent = childFundAgent.getMoneyAgent();
        String costMenber = childFundAgent.getCostMenber();
        FamilyTransferAccount transferAccount = new FamilyTransferAccount();
        if (!moneyAgent.equals(costMenber)){
            transferAccount.setTransferAccount(childFundAgent.getFundAmount());
            transferAccount.setTransfer(costMenber);
            transferAccount.setAccepter(moneyAgent);
            transferAccount.setTransferTime(childFundAgent.getAgentDate());
            transferAccount.setCreateUser(childFundAgent.getCreateUser());
            transferAccount.setCreateTime(childFundAgent.getCreateTime());
            transferAccount.setBusinessType("孩子管理->资金代管");
            transferAccount.setBusinessId(childFundAgent.getId());
            String remark ="出资人"+dictDataMapper.selectDictLabel("family_menber",costMenber)
                    +"转账给"+dictDataMapper.selectDictLabel("family_menber",moneyAgent)
                    +"为宝贝"+dictDataMapper.selectDictLabel("child_code",childFundAgent.getChildCode());
            transferAccount.setRemark(remark);
            transferAccountMapper.insertFamilyTransferAccount(transferAccount);
            //互相关联
            childFundAgent.setBusinessId(transferAccount.getId());
            childFundAgentMapper.updateFamilyChildFundAgent(childFundAgent);
        }
        return childFundAgent.getId();
    }

    /**
     * 修改资金代管
     * 
     * @param childFundAgent 资金代管
     * @return 结果
     */
    @Override
    public int updateFamilyChildFundAgent(FamilyChildFundAgent childFundAgent1)
    {
        Long id = childFundAgent1.getId();
        FamilyChildFundAgent childFundAgent = childFundAgentMapper.selectFamilyChildFundAgentById(id);
        dataOverProtect(childFundAgent);
        String moneyAgent = childFundAgent.getMoneyAgent();
        String costMenber = childFundAgent.getCostMenber();
        FamilyTransferAccount transferAccount = new FamilyTransferAccount();
        if (!moneyAgent.equals(costMenber)){
            transferAccount.setTransferAccount(childFundAgent1.getFundAmount());
            transferAccount.setTransferTime(childFundAgent1.getAgentDate());
            transferAccount.setId(childFundAgent.getBusinessId());
            transferAccountMapper.updateFamilyTransferAccount(transferAccount);
        }
        return childFundAgentMapper.updateFamilyChildFundAgent(childFundAgent1);
    }

    @Autowired
    private ISysConfigService configService;

    private void dataOverProtect(FamilyChildFundAgent familyPay) {
        Date createDate = familyPay.getCreateTime();
        if ("true".equals(configService.selectConfigByKey("sys.delorupdate.timelimit"))
                &&DateUtils.differentDaysByMillisecond(new Date(), createDate) > 3) {
            throw new BusinessException("创建时间已过3天,不允许操作");
        }
    }

    /**
     * 批量删除资金代管
     * 
     * @param ids 需要删除的资金代管主键
     * @return 结果
     */
    @Override
    public int deleteFamilyChildFundAgentByIds(String ids)
    {
        String[] strings = Convert.toStrArray(ids);
        for (String string : strings) {
            FamilyChildFundAgent familyChildFundAgent = childFundAgentMapper.selectFamilyChildFundAgentById(Long.valueOf(string));
            dataOverProtect(familyChildFundAgent);
            if (ObjectUtils.isNotEmpty(familyChildFundAgent.getBusinessId())) {
                transferAccountMapper.deleteFamilyTransferAccountById(familyChildFundAgent.getBusinessId());
            }
        }
        return childFundAgentMapper.deleteFamilyChildFundAgentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资金代管信息
     * 
     * @param id 资金代管主键
     * @return 结果
     */
    @Override
    public int deleteFamilyChildFundAgentById(Long id)
    {
        return childFundAgentMapper.deleteFamilyChildFundAgentById(id);
    }
}
