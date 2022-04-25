package com.ruoyi.payincome.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.payincome.mapper.FamilyIncomeMapper;
import com.ruoyi.payincome.domain.FamilyIncome;
import com.ruoyi.payincome.service.IFamilyIncomeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 家庭收入Service业务层处理
 * 
 * @author 刘兴武
 * @date 2021-09-10
 */
@Service
public class FamilyIncomeServiceImpl implements IFamilyIncomeService 
{
    @Autowired
    private FamilyIncomeMapper familyIncomeMapper;
    @Autowired
    private ISysConfigService configService;
    /**
     * 查询家庭收入
     * 
     * @param id 家庭收入主键
     * @return 家庭收入
     */
    @Override
    public FamilyIncome selectFamilyIncomeById(Long id)
    {
        return familyIncomeMapper.selectFamilyIncomeById(id);
    }

    /**
     * 查询家庭收入列表
     * 
     * @param familyIncome 家庭收入
     * @return 家庭收入
     */
    @Override
    public List<FamilyIncome> selectFamilyIncomeList(FamilyIncome familyIncome)
    {
        return familyIncomeMapper.selectFamilyIncomeList(familyIncome);
    }

    /**
     * 新增家庭收入
     * 
     * @param familyIncome 家庭收入
     * @return 结果
     */
    @Override
    public int insertFamilyIncome(FamilyIncome familyIncome)
    {
        familyIncome.setCreateDate(new Date());
        familyIncome.setBookkeeperCode(ShiroUtils.getLoginName());
        return familyIncomeMapper.insertFamilyIncome(familyIncome);
    }

    /**
     * 修改家庭收入
     * 
     * @param familyIncome 家庭收入
     * @return 结果
     */
    @Override
    public int updateFamilyIncome(FamilyIncome familyIncome)
    {
        FamilyIncome familyIncome1 = familyIncomeMapper.selectFamilyIncomeById(familyIncome.getId());
        dataOverProtect(familyIncome1);
        return familyIncomeMapper.updateFamilyIncome(familyIncome);
    }



    private void dataOverProtect(FamilyIncome familyPay) {
        Date createDate = familyPay.getCreateDate();
        if ( "true".equals(configService.selectConfigByKey("sys.delorupdate.timelimit"))
                &&DateUtils.differentDaysByMillisecond(new Date(), createDate) > 3) {
            throw new BusinessException("创建时间已过3天,不允许操作");
        }
    }

    /**
     * 批量删除家庭收入
     * 
     * @param ids 需要删除的家庭收入主键
     * @return 结果
     */
    @Override
    public int deleteFamilyIncomeByIds(String ids)
    {
        String[] strings = Convert.toStrArray(ids);
        for (String string : strings) {
            FamilyIncome familyIncome = familyIncomeMapper.selectFamilyIncomeById(Long.valueOf(string));
            dataOverProtect(familyIncome);
            familyIncomeMapper.deleteFamilyIncomeById(Long.valueOf(string));
        }
//        return familyIncomeMapper.deleteFamilyIncomeByIds(Convert.toStrArray(ids));
        return 1;
    }

    /**
     * 删除家庭收入信息
     * 
     * @param id 家庭收入主键
     * @return 结果
     */
    @Override
    public int deleteFamilyIncomeById(Long id)
    {
        return familyIncomeMapper.deleteFamilyIncomeById(id);
    }
}
