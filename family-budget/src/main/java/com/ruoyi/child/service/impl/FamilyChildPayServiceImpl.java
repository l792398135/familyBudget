package com.ruoyi.child.service.impl;

import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
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
            sysAttachment.setBusinessType("businessType");
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
        return familyChildPayMapper.deleteFamilyChildPayByIds(Convert.toStrArray(ids));
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
