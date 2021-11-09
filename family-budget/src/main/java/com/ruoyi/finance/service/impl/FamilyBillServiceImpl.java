package com.ruoyi.finance.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.finance.mapper.FamilyBillMapper;
import com.ruoyi.finance.domain.FamilyBill;
import com.ruoyi.finance.service.IFamilyBillService;
import com.ruoyi.common.core.text.Convert;

/**
 * 单据管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
@Service
public class FamilyBillServiceImpl implements IFamilyBillService 
{
    @Autowired
    private FamilyBillMapper familyBillMapper;

    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;
    /**
     * 查询单据管理
     * 
     * @param id 单据管理主键
     * @return 单据管理
     */
    @Override
    public FamilyBill selectFamilyBillById(Long id)
    {
        return familyBillMapper.selectFamilyBillById(id);
    }


    /**
     * 查询单据管理列表
     * 
     * @param familyBill 单据管理
     * @return 单据管理
     */
    @Override
    public List<FamilyBill> selectFamilyBillList(FamilyBill familyBill)
    {
        List<FamilyBill> familyBills = familyBillMapper.selectFamilyBillList(familyBill);
        for (int i = 0; i <familyBills.size() ; i++) {
            FamilyBill fixedAssets =familyBills.get(i);
            Long id = fixedAssets.getId();
            SysAttachment sysAttachment = new SysAttachment();
            sysAttachment.setBusinessId(String.valueOf(id));
            sysAttachment.setBusinessType("bill");
            sysAttachment.setDelFlag(0);
            List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
            if (sysAttachments!=null) {
                List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                fixedAssets.setImgUrls(collect);
            }
            familyBills.set(i,fixedAssets);
        }
        return familyBills;
    }

    /**
     * 新增单据管理
     * 
     * @param familyBill 单据管理
     * @return 结果
     */
    @Override
    public Long insertFamilyBill(FamilyBill familyBill)
    {
        familyBill.setCreateUser(ShiroUtils.getLoginName());
        familyBill.setCreateTime(DateUtils.getNowDate());
        familyBillMapper.insertFamilyBill(familyBill);
        Long id = familyBill.getId();
        return id;
    }

    /**
     * 修改单据管理
     * 
     * @param familyBill 单据管理
     * @return 结果
     */
    @Override
    public int updateFamilyBill(FamilyBill familyBill)
    {
        return familyBillMapper.updateFamilyBill(familyBill);
    }

    /**
     * 批量删除单据管理
     * 
     * @param ids 需要删除的单据管理主键
     * @return 结果
     */
    @Override
    public int deleteFamilyBillByIds(String ids)
    {
        return familyBillMapper.deleteFamilyBillByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除单据管理信息
     * 
     * @param id 单据管理主键
     * @return 结果
     */
    @Override
    public int deleteFamilyBillById(Long id)
    {
        return familyBillMapper.deleteFamilyBillById(id);
    }
}
