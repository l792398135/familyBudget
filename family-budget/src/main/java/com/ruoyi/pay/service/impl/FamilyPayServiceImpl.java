package com.ruoyi.pay.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pay.mapper.FamilyPayMapper;
import com.ruoyi.pay.domain.FamilyPay;
import com.ruoyi.pay.service.IFamilyPayService;
import com.ruoyi.common.core.text.Convert;

/**
 * 费用支出Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
@Service
public class FamilyPayServiceImpl implements IFamilyPayService 
{
    @Autowired
    private FamilyPayMapper familyPayMapper;

    /**
     * 查询费用支出
     * 
     * @param id 费用支出主键
     * @return 费用支出
     */
    @Override
    public FamilyPay selectFamilyPayById(Long id)
    {
        return familyPayMapper.selectFamilyPayById(id);
    }

    /**
     * 查询费用支出列表
     * 
     * @param familyPay 费用支出
     * @return 费用支出
     */
    @Override
    public List<FamilyPay> selectFamilyPayList(FamilyPay familyPay)
    {
        return familyPayMapper.selectFamilyPayList(familyPay);
    }

    /**
     * 新增费用支出
     * 
     * @param familyPay 费用支出
     * @return 结果
     */
    @Override
    public int insertFamilyPay(FamilyPay familyPay)
    {
        familyPay.setCreateDate(new Date());
        familyPay.setBookkeeperCode(ShiroUtils.getLoginName());
        return familyPayMapper.insertFamilyPay(familyPay);
    }

    /**
     * 修改费用支出
     * 
     * @param familyPay 费用支出
     * @return 结果
     */
    @Override
    public int updateFamilyPay(FamilyPay familyPay)
    {
        FamilyPay familyPay1 = familyPayMapper.selectFamilyPayById(familyPay.getId());
        dataOverProtect(familyPay1);
        return familyPayMapper.updateFamilyPay(familyPay);
    }

    /**
     * 批量删除费用支出
     * 
     * @param ids 需要删除的费用支出主键
     * @return 结果
     */
    @Override
    public int deleteFamilyPayByIds(String ids)
    {
        String[] strings = Convert.toStrArray(ids);
        for (String string : strings) {
            FamilyPay familyPay = familyPayMapper.selectFamilyPayById(Long.valueOf(string));
            dataOverProtect(familyPay);
            familyPayMapper.deleteFamilyPayById(Long.valueOf(string));
        }
//        return familyPayMapper.deleteFamilyPayByIds(Convert.toStrArray(ids));
        return 1;
    }

    private void dataOverProtect(FamilyPay familyPay) {
        Date createDate = familyPay.getCreateDate();
        if (DateUtils.differentDaysByMillisecond(new Date(), createDate) > 3) {
            throw new BusinessException("创建时间已过3天,不允许操作");
        }
    }

    /**
     * 删除费用支出信息
     * 
     * @param id 费用支出主键
     * @return 结果
     */
    @Override
    public int deleteFamilyPayById(Long id)
    {
        return familyPayMapper.deleteFamilyPayById(id);
    }
}
