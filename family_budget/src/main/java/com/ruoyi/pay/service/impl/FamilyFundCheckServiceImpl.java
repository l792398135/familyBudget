package com.ruoyi.pay.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pay.mapper.FamilyFundCheckMapper;
import com.ruoyi.pay.domain.FamilyFundCheck;
import com.ruoyi.pay.service.IFamilyFundCheckService;
import com.ruoyi.common.core.text.Convert;

/**
 * 盘点Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
@Service
public class FamilyFundCheckServiceImpl implements IFamilyFundCheckService 
{
    @Autowired
    private FamilyFundCheckMapper familyFundCheckMapper;

    /**
     * 查询盘点
     * 
     * @param id 盘点主键
     * @return 盘点
     */
    @Override
    public FamilyFundCheck selectFamilyFundCheckById(Long id)
    {
        return familyFundCheckMapper.selectFamilyFundCheckById(id);
    }

    /**
     * 查询盘点列表
     * 
     * @param familyFundCheck 盘点
     * @return 盘点
     */
    @Override
    public List<FamilyFundCheck> selectFamilyFundCheckList(FamilyFundCheck familyFundCheck)
    {
        return familyFundCheckMapper.selectFamilyFundCheckList(familyFundCheck);
    }

    /**
     * 新增盘点
     * 
     * @param familyFundCheck 盘点
     * @return 结果
     */
    @Override
    public int insertFamilyFundCheck(FamilyFundCheck familyFundCheck)
    {
        String s = DateUtils.dateTimeNow(DateUtils.YYYYMMDDHHMMSS);
        familyFundCheck.setCheckCode("check"+s);
        familyFundCheck.setCreateUser(ShiroUtils.getLoginName());
        familyFundCheck.setCreateTime(DateUtils.getNowDate());
        return familyFundCheckMapper.insertFamilyFundCheck(familyFundCheck);
    }

    /**
     * 修改盘点
     * 
     * @param familyFundCheck 盘点
     * @return 结果
     */
    @Override
    public int updateFamilyFundCheck(FamilyFundCheck familyFundCheck)
    {
        return familyFundCheckMapper.updateFamilyFundCheck(familyFundCheck);
    }

    /**
     * 批量删除盘点
     * 
     * @param ids 需要删除的盘点主键
     * @return 结果
     */
    @Override
    public int deleteFamilyFundCheckByIds(String ids)
    {
        return familyFundCheckMapper.deleteFamilyFundCheckByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除盘点信息
     * 
     * @param id 盘点主键
     * @return 结果
     */
    @Override
    public int deleteFamilyFundCheckById(Long id)
    {
        return familyFundCheckMapper.deleteFamilyFundCheckById(id);
    }
}