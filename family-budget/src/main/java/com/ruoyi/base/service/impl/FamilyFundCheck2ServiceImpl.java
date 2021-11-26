package com.ruoyi.base.service.impl;

import com.ruoyi.base.domain.FamilyFundCheck2;
import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.base.mapper.FamilyFundCheck2Mapper;
import com.ruoyi.base.service.IFamilyFundCheck2Service;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
/**
 * 盘点设置Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-26
 */
@Service
public class FamilyFundCheck2ServiceImpl implements IFamilyFundCheck2Service
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    @Autowired
    private FamilyFundCheck2Mapper familyFundCheckMapper;

    /**
     * 查询盘点设置
     * 
     * @param id 盘点设置主键
     * @return 盘点设置
     */
    @Override
    public FamilyFundCheck2 selectFamilyFundCheckById(Long id)
    {
        return familyFundCheckMapper.selectFamilyFundCheckById(id);
    }

    /**
     * 查询盘点设置列表
     * 
     * @param familyFundCheck2 盘点设置
     * @return 盘点设置
     */
    @Override
    public List<FamilyFundCheck2> selectFamilyFundCheckList(FamilyFundCheck2 familyFundCheck2)
    {
        List<FamilyFundCheck2> familyFundCheck21 = familyFundCheckMapper.selectFamilyFundCheckList(familyFundCheck2);
        return familyFundCheck21;
    }

    /**
     * 新增盘点设置
     * 
     * @param familyFundCheck2 盘点设置
     * @return 结果
     */
    @Override
    public Long insertFamilyFundCheck(FamilyFundCheck2 familyFundCheck2)
    {
        familyFundCheck2.setCreateTime(DateUtils.getNowDate());
        familyFundCheck2.setCreateUser(ShiroUtils.getLoginName());
        familyFundCheckMapper.insertFamilyFundCheck(familyFundCheck2);
        return familyFundCheck2.getId();
    }

    /**
     * 修改盘点设置
     * 
     * @param familyFundCheck2 盘点设置
     * @return 结果
     */
    @Override
    public int updateFamilyFundCheck(FamilyFundCheck2 familyFundCheck2)
    {
        return familyFundCheckMapper.updateFamilyFundCheck(familyFundCheck2);
    }

    /**
     * 批量删除盘点设置
     * 
     * @param ids 需要删除的盘点设置主键
     * @return 结果
     */
    @Override
    public int deleteFamilyFundCheckByIds(String ids)
    {
        return familyFundCheckMapper.deleteFamilyFundCheckByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除盘点设置信息
     * 
     * @param id 盘点设置主键
     * @return 结果
     */
    @Override
    public int deleteFamilyFundCheckById(Long id)
    {
        return familyFundCheckMapper.deleteFamilyFundCheckById(id);
    }
}
