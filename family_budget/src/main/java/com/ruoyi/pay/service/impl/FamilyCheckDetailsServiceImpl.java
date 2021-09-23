package com.ruoyi.pay.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pay.mapper.FamilyCheckDetailsMapper;
import com.ruoyi.pay.domain.FamilyCheckDetails;
import com.ruoyi.pay.service.IFamilyCheckDetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 盘点详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-23
 */
@Service
public class FamilyCheckDetailsServiceImpl implements IFamilyCheckDetailsService 
{
    @Autowired
    private FamilyCheckDetailsMapper familyCheckDetailsMapper;

    /**
     * 查询盘点详情
     * 
     * @param id 盘点详情主键
     * @return 盘点详情
     */
    @Override
    public FamilyCheckDetails selectFamilyCheckDetailsById(Long id)
    {
        return familyCheckDetailsMapper.selectFamilyCheckDetailsById(id);
    }

    /**
     * 查询盘点详情列表
     * 
     * @param familyCheckDetails 盘点详情
     * @return 盘点详情
     */
    @Override
    public List<FamilyCheckDetails> selectFamilyCheckDetailsList(FamilyCheckDetails familyCheckDetails)
    {
        return familyCheckDetailsMapper.selectFamilyCheckDetailsList(familyCheckDetails);
    }

    /**
     * 新增盘点详情
     * 
     * @param familyCheckDetails 盘点详情
     * @return 结果
     */
    @Override
    public Long insertFamilyCheckDetails(FamilyCheckDetails familyCheckDetails)
    {
        familyCheckDetails.setCreateTime(DateUtils.getNowDate());
        int i = familyCheckDetailsMapper.insertFamilyCheckDetails(familyCheckDetails);
        return familyCheckDetails.getId();
    }

    /**
     * 修改盘点详情
     * 
     * @param familyCheckDetails 盘点详情
     * @return 结果
     */
    @Override
    public int updateFamilyCheckDetails(FamilyCheckDetails familyCheckDetails)
    {
        return familyCheckDetailsMapper.updateFamilyCheckDetails(familyCheckDetails);
    }

    /**
     * 批量删除盘点详情
     * 
     * @param ids 需要删除的盘点详情主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCheckDetailsByIds(String ids)
    {
        return familyCheckDetailsMapper.deleteFamilyCheckDetailsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除盘点详情信息
     * 
     * @param id 盘点详情主键
     * @return 结果
     */
    @Override
    public int deleteFamilyCheckDetailsById(Long id)
    {
        return familyCheckDetailsMapper.deleteFamilyCheckDetailsById(id);
    }
}
