package com.ruoyi.child.service.impl;

import com.ruoyi.child.domain.FamilyChildFundAgent;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.ShiroUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.payincome.domain.FamilyPay;
import com.ruoyi.payincome.mapper.FamilyPayMapper;
import com.ruoyi.system.mapper.SysDictDataMapper;
import com.ruoyi.system.service.ISysConfigService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.child.mapper.FamilyChildPayMapper;
import com.ruoyi.child.domain.FamilyChildPay;
import com.ruoyi.child.service.IFamilyChildPayService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 宝贝支出Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
@Service
public class FamilyChildPayServiceImpl implements IFamilyChildPayService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyChildPayMapper familyChildPayMapper;

    @Autowired
    private FamilyPayMapper payMapper;

    @Autowired
    private SysDictDataMapper dictDataMapper;
    /**
     * 查询宝贝支出
     * 
     * @param id 宝贝支出主键
     * @return 宝贝支出
     */
    @Override
    public FamilyChildPay selectFamilyChildPayById(Long id)
    {
        return familyChildPayMapper.selectFamilyChildPayById(id);
    }

    /**
     * 查询宝贝支出列表
     * 
     * @param familyChildPay 宝贝支出
     * @return 宝贝支出
     */
    @Override
    public List<FamilyChildPay> selectFamilyChildPayList(FamilyChildPay familyChildPay)
    {
        List<FamilyChildPay> familyChildPay1= familyChildPayMapper.selectFamilyChildPayList(familyChildPay);
        for (int i = 0; i <familyChildPay1.size() ; i++) {
            FamilyChildPay item =familyChildPay1.get(i);
            Long id = item.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("childPay");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                item.setImgUrls(collect);
            }
            familyChildPay1.set(i,item);
        }
        return familyChildPay1;
    }

    /**
     * 新增宝贝支出
     * 
     * @param familyChildPay 宝贝支出
     * @return 结果
     */
    @Override
    public Long insertFamilyChildPay(FamilyChildPay familyChildPay)
    {
        familyChildPay.setCreateTime(DateUtils.getNowDate());
        familyChildPay.setCreateUser(ShiroUtils.getLoginName());
        familyChildPayMapper.insertFamilyChildPay(familyChildPay);
        //
        FamilyPay familyPay = new FamilyPay();
        familyPay.setPayMenber(familyChildPay.getPayMenber());
        familyPay.setPayDate(familyChildPay.getPayDate());
        familyPay.setPayCost(familyChildPay.getPayAmount());
        familyPay.setPayTypeCode("child");
        familyPay.setOperatorCode(ShiroUtils.getLoginName());
        familyPay.setBookkeeperCode(familyChildPay.getPayMenber());
        familyPay.setCreateDate(new Date());
        familyPay.setBusinessType("孩子管理->宝贝支出");
        familyPay.setBusinessId(familyChildPay.getId());
        String remark =dictDataMapper.selectDictLabel("family_menber",familyChildPay.getPayMenber())
                +"为宝贝"+dictDataMapper.selectDictLabel("child_code",familyChildPay.getBenefitChild())
                +"购买"+dictDataMapper.selectDictLabel("child_pay_code",familyChildPay.getPayCode());
        familyPay.setPayDetail(remark);
        payMapper.insertFamilyPay(familyPay);
        familyChildPay.setBusinessId(familyPay.getId());
        familyChildPayMapper.updateFamilyChildPay(familyChildPay);
        return familyChildPay.getId();
    }

    /**
     * 修改宝贝支出
     * 
     * @param familyChildPay 宝贝支出
     * @return 结果
     */
    @Override
    public int updateFamilyChildPay(FamilyChildPay familyChildPay)
    {
        FamilyChildPay familyChildPay1 = familyChildPayMapper.selectFamilyChildPayById(familyChildPay.getId());
        dataOverProtect(familyChildPay1);
        FamilyPay familyPay = new FamilyPay();
        familyPay.setPayDate(familyChildPay.getPayDate());
        familyPay.setPayCost(familyChildPay.getPayAmount());
        familyPay.setId(familyChildPay1.getBusinessId());
        payMapper.updateFamilyPay(familyPay);
        return familyChildPayMapper.updateFamilyChildPay(familyChildPay);
    }

    /**
     * 批量删除宝贝支出
     * 
     * @param ids 需要删除的宝贝支出主键
     * @return 结果
     */
    @Override
    public int deleteFamilyChildPayByIds(String ids)
    {
        String[] strings = Convert.toStrArray(ids);
        for (String string : strings) {
            FamilyChildPay familyChildPay = familyChildPayMapper.selectFamilyChildPayById(Long.valueOf(string));
            dataOverProtect(familyChildPay);
            if (ObjectUtils.isNotEmpty(familyChildPay.getBusinessId())) {
                payMapper.deleteFamilyPayById(familyChildPay.getBusinessId());
            }
        }
        return familyChildPayMapper.deleteFamilyChildPayByIds(Convert.toStrArray(ids));
    }

    @Autowired
    private ISysConfigService configService;

    private void dataOverProtect(FamilyChildPay familyPay) {
        Date createDate = familyPay.getCreateTime();
        if ("true".equals(configService.selectConfigByKey("sys.delorupdate.timelimit"))
                &&DateUtils.differentDaysByMillisecond(new Date(), createDate) > 3) {
            throw new BusinessException("创建时间已过3天,不允许操作");
        }
    }
    /**
     * 删除宝贝支出信息
     * 
     * @param id 宝贝支出主键
     * @return 结果
     */
    @Override
    public int deleteFamilyChildPayById(Long id)
    {
        return familyChildPayMapper.deleteFamilyChildPayById(id);
    }
}
