package com.ruoyi.pay.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.pay.domain.FamilyMonthBudget;
import com.ruoyi.pay.mapper.FamilyMonthBudgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pay.mapper.FamilyMonthBudgetDetailsMapper;
import com.ruoyi.pay.domain.FamilyMonthBudgetDetails;
import com.ruoyi.pay.service.IFamilyMonthBudgetDetailsService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 预算明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-19
 */
@Service
public class FamilyMonthBudgetDetailsServiceImpl implements IFamilyMonthBudgetDetailsService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyMonthBudgetDetailsMapper familyMonthBudgetDetailsMapper;
    @Autowired
    private FamilyMonthBudgetMapper monthBudgetMapper;

    /**
     * 查询预算明细
     * 
     * @param id 预算明细主键
     * @return 预算明细
     */
    @Override
    public FamilyMonthBudgetDetails selectFamilyMonthBudgetDetailsById(Long id)
    {
        return familyMonthBudgetDetailsMapper.selectFamilyMonthBudgetDetailsById(id);
    }

    /**
     * 查询预算明细列表
     * 
     * @param familyMonthBudgetDetails 预算明细
     * @return 预算明细
     */
    @Override
    public List<FamilyMonthBudgetDetails> selectFamilyMonthBudgetDetailsList(FamilyMonthBudgetDetails familyMonthBudgetDetails)
    {
        List<FamilyMonthBudgetDetails> familyMonthBudgetDetails1= familyMonthBudgetDetailsMapper.selectFamilyMonthBudgetDetailsList(familyMonthBudgetDetails);
        return familyMonthBudgetDetails1;
    }

    /**
     * 新增预算明细
     * 
     * @param familyMonthBudgetDetails 预算明细
     * @return 结果
     */
    @Override
    public Long insertFamilyMonthBudgetDetails(FamilyMonthBudgetDetails familyMonthBudgetDetails)
    {
        familyMonthBudgetDetails.setCreateUser(ShiroUtils.getLoginName());
        familyMonthBudgetDetailsMapper.insertFamilyMonthBudgetDetails(familyMonthBudgetDetails);
        return familyMonthBudgetDetails.getId();
    }

    /**
     * 修改预算明细
     * 
     * @param familyMonthBudgetDetails 预算明细
     * @return 结果
     */
    @Override
    public int updateFamilyMonthBudgetDetails(FamilyMonthBudgetDetails familyMonthBudgetDetails)
    {
        familyMonthBudgetDetailsMapper.updateFamilyMonthBudgetDetails(familyMonthBudgetDetails);
        Long id = familyMonthBudgetDetails.getId();
        FamilyMonthBudgetDetails familyMonthBudgetDetails1 =familyMonthBudgetDetailsMapper.selectFamilyMonthBudgetDetailsById(id);

        //计算预算总额
        String budgetDate = familyMonthBudgetDetails1.getBudgetDate();
        String budgetType = familyMonthBudgetDetails1.getBudgetType();
        String dictType = familyMonthBudgetDetails1.getDictType();
        BigDecimal sum = familyMonthBudgetDetailsMapper.sumBudgetBy(budgetDate,budgetType,dictType);
        FamilyMonthBudget familyMonthBudget = new FamilyMonthBudget();
        try {
            familyMonthBudget.setBudgetDate(DateUtils.parseDate(budgetDate,"yyyy-MM"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        familyMonthBudget.setBudgetType(budgetType);

        List<FamilyMonthBudget> familyMonthBudgets = monthBudgetMapper.selectFamilyMonthBudgetList(familyMonthBudget);
        FamilyMonthBudget familyMonthBudget1 = familyMonthBudgets.get(0);
        if (dictType.equals("budget_type")){
            familyMonthBudget1.setBudgetCost(sum);
        }
        if (dictType.equals("income_type")){
            familyMonthBudget1.setBudgetIncome(sum);
        }
        monthBudgetMapper.updateFamilyMonthBudget(familyMonthBudget1);
        return 1;
    }

    /**
     * 批量删除预算明细
     * 
     * @param ids 需要删除的预算明细主键
     * @return 结果
     */
    @Override
    public int deleteFamilyMonthBudgetDetailsByIds(String ids)
    {
        return familyMonthBudgetDetailsMapper.deleteFamilyMonthBudgetDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除预算明细信息
     * 
     * @param id 预算明细主键
     * @return 结果
     */
    @Override
    public int deleteFamilyMonthBudgetDetailsById(Long id)
    {
        return familyMonthBudgetDetailsMapper.deleteFamilyMonthBudgetDetailsById(id);
    }
}
