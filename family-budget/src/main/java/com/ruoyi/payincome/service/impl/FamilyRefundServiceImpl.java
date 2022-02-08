package com.ruoyi.payincome.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.payincome.domain.FamilyPay;
import com.ruoyi.payincome.mapper.FamilyRefundMapper;
import com.ruoyi.payincome.service.IFamilyPayService;
import com.ruoyi.payincome.service.IFamilyRefundService;
import com.ruoyi.system.service.ISysConfigService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 费用支出Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
@Service
public class FamilyRefundServiceImpl implements IFamilyRefundService
{
    @Autowired
    private FamilyRefundMapper refundMapper;

    /**
     * 查询费用支出
     * 
     * @param id 费用支出主键
     * @return 费用支出
     */
    @Override
    public FamilyPay selectFamilyPayById(Long id)
    {
        return refundMapper.selectFamilyPayById(id);
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
        return refundMapper.selectFamilyPayList(familyPay);
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
        return refundMapper.insertFamilyPay(familyPay);
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
        FamilyPay familyPay1 = refundMapper.selectFamilyPayById(familyPay.getId());
        dataOverProtect(familyPay1);
        return refundMapper.updateFamilyPay(familyPay);
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
            FamilyPay familyPay = refundMapper.selectFamilyPayById(Long.valueOf(string));
            dataOverProtect(familyPay);
            Long businessId = familyPay.getBusinessId();
            if (!ObjectUtils.isEmpty(businessId)){
                throw new BusinessException("其他操作生成的记录，不允许此处修改！");
            }
            refundMapper.deleteFamilyPayById(Long.valueOf(string));
        }
        return 1;
    }

    @Autowired
    private ISysConfigService configService;

    private void dataOverProtect(FamilyPay familyPay) {
        Date createDate = familyPay.getCreateDate();
        if ("true".equals(configService.selectConfigByKey("sys.delorupdate.timelimit"))
                &&DateUtils.differentDaysByMillisecond(new Date(), createDate) > 3) {
            throw new BusinessException("创建时间已过3天,不允许操作");
        }
    }
}
