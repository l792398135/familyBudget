package com.ruoyi.search.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.search.mapper.FamilyBillMapper;
import com.ruoyi.search.domain.FamilyBill;
import com.ruoyi.search.service.IFamilyBillService;
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
        return familyBillMapper.selectFamilyBillList(familyBill);
    }

    /**
     * 新增单据管理
     * 
     * @param familyBill 单据管理
     * @return 结果
     */
    @Override
    public int insertFamilyBill(FamilyBill familyBill)
    {
        familyBill.setCreateTime(DateUtils.getNowDate());
        return familyBillMapper.insertFamilyBill(familyBill);
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
