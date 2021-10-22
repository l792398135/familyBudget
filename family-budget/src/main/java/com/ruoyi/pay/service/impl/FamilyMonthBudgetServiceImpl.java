package com.ruoyi.pay.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.base.domain.FamilyFeeType;
import com.ruoyi.base.service.impl.FamilyFeeTypeServiceImpl;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.pay.domain.FamilyMonthBudgetDetails;
import com.ruoyi.pay.mapper.FamilyMonthBudgetDetailsMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pay.mapper.FamilyMonthBudgetMapper;
import com.ruoyi.pay.domain.FamilyMonthBudget;
import com.ruoyi.pay.service.IFamilyMonthBudgetService;
import com.ruoyi.common.core.text.Convert;

/**
 * 月预算Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-14
 */
@Service
public class FamilyMonthBudgetServiceImpl implements IFamilyMonthBudgetService 
{
    @Autowired
    private FamilyMonthBudgetMapper familyMonthBudgetMapper;
    @Autowired
    private FamilyFeeTypeServiceImpl feeTypeService;
    @Autowired
    private FamilyMonthBudgetDetailsMapper budgetDetailsMapper;

    /**
     * 查询月预算
     * 
     * @param id 月预算主键
     * @return 月预算
     */
    @Override
    public FamilyMonthBudget selectFamilyMonthBudgetById(Long id)
    {
        return familyMonthBudgetMapper.selectFamilyMonthBudgetById(id);
    }

    /**
     * 查询月预算列表
     * 
     * @param familyMonthBudget 月预算
     * @return 月预算
     */
    @Override
    public List<FamilyMonthBudget> selectFamilyMonthBudgetList(FamilyMonthBudget familyMonthBudget)
    {
        return familyMonthBudgetMapper.selectFamilyMonthBudgetList(familyMonthBudget);
    }

    /**
     * 新增月预算
     * 
     * @param familyMonthBudget 月预算
     * @return 结果
     */
    @Override
    public int insertFamilyMonthBudget(FamilyMonthBudget familyMonthBudget) {
        Date budgetDate = familyMonthBudget.getBudgetDate();
        String budgetType = familyMonthBudget.getBudgetType();
        //查询预算周期是否已经创建
        if (budgetType.equals("plan")) {
            List<FamilyMonthBudget> familyMonthBudgets = familyMonthBudgetMapper.selectFamilyMonthBudgetList(familyMonthBudget);
            if (CollectionUtils.isNotEmpty(familyMonthBudgets)){
                throw new BusinessException("这个周期的计划预算已经创建");
            }
        }

        FamilyFeeType familyFeeType = new FamilyFeeType();
        familyFeeType.setControlFlag("0");
        List<FamilyFeeType> familyFeeTypes = feeTypeService.selectFamilyFeeTypeList(familyFeeType);
        for (FamilyFeeType feeType : familyFeeTypes) {
            FamilyMonthBudgetDetails budgetDetails = new FamilyMonthBudgetDetails();
            budgetDetails.setDictValue(feeType.getDictValue());
            budgetDetails.setDictLabel(feeType.getDictLabel());
            budgetDetails.setDictSort(feeType.getDictSort());
            budgetDetails.setDictType(feeType.getDictType());
            budgetDetails.setDictTypeName(feeType.getDictTypeName());
            budgetDetails.setBudgetDate(DateUtils.parseDateToStr("yyyy-MM", budgetDate));
            budgetDetails.setBudgetType(budgetType);
            budgetDetailsMapper.insertFamilyMonthBudgetDetails(budgetDetails);
        }
        familyMonthBudget.setCreateDate(new Date());
        familyMonthBudget.setCreateUser(ShiroUtils.getLoginName());
        return familyMonthBudgetMapper.insertFamilyMonthBudget(familyMonthBudget);
    }
    /**
     * 修改月预算
     * 
     * @param familyMonthBudget 月预算
     * @return 结果
     */
    @Override
    public int updateFamilyMonthBudget(FamilyMonthBudget familyMonthBudget)
    {
        return familyMonthBudgetMapper.updateFamilyMonthBudget(familyMonthBudget);
    }

    /**
     * 批量删除月预算
     * 
     * @param ids 需要删除的月预算主键
     * @return 结果
     */
    @Override
    public int deleteFamilyMonthBudgetByIds(String ids)
    {
        String[] strings = Convert.toStrArray(ids);
        for (String string : strings) {
            FamilyMonthBudget familyMonthBudget = familyMonthBudgetMapper.selectFamilyMonthBudgetById(Long.parseLong(string));
            if (familyMonthBudget.getBudgetType().equals("plan")) {
                FamilyMonthBudgetDetails budgetDetails = new FamilyMonthBudgetDetails();
                budgetDetails.setBudgetDate(DateUtils.parseDateToStr("yyyy-MM", familyMonthBudget.getBudgetDate()));
                budgetDetails.setBudgetType(familyMonthBudget.getBudgetType());
                List<FamilyMonthBudgetDetails> familyMonthBudgetDetails = budgetDetailsMapper.selectFamilyMonthBudgetDetailsList(budgetDetails);
                if (CollectionUtils.isNotEmpty(familyMonthBudgetDetails)){
                    throw new BusinessException(DateUtils.parseDateToStr("yyyy-MM", familyMonthBudget.getBudgetDate())+"预算周期存在下级科目");
                }
            }
        }
        return familyMonthBudgetMapper.deleteFamilyMonthBudgetByIds(strings);
    }

    /**
     * 删除月预算信息
     * 
     * @param id 月预算主键
     * @return 结果
     */
    @Override
    public int deleteFamilyMonthBudgetById(Long id)
    {
        return familyMonthBudgetMapper.deleteFamilyMonthBudgetById(id);
    }

}
