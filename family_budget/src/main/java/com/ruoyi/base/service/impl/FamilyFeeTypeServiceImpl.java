package com.ruoyi.base.service.impl;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.utils.ShiroUtils;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.system.mapper.SysDictDataMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.base.mapper.FamilyFeeTypeMapper;
import com.ruoyi.base.domain.FamilyFeeType;
import com.ruoyi.base.service.IFamilyFeeTypeService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 费用类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-19
 */
@Service
public class FamilyFeeTypeServiceImpl implements IFamilyFeeTypeService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;
    @Autowired
    private SysDictDataMapper sysDictDataMapper;

    @Autowired
    private FamilyFeeTypeMapper familyFeeTypeMapper;

    /**
     * 查询费用类型
     * 
     * @param id 费用类型主键
     * @return 费用类型
     */
    @Override
    public FamilyFeeType selectFamilyFeeTypeById(Long id)
    {
        return familyFeeTypeMapper.selectFamilyFeeTypeById(id);
    }

    /**
     * 查询费用类型列表
     * 
     * @param familyFeeType 费用类型
     * @return 费用类型
     */
    @Override
    public List<FamilyFeeType> selectFamilyFeeTypeList(FamilyFeeType familyFeeType)
    {
        List<FamilyFeeType> familyFeeType1= familyFeeTypeMapper.selectFamilyFeeTypeList(familyFeeType);
        return familyFeeType1;
    }

    /**
     * 新增费用类型
     * 
     * @param familyFeeType 费用类型
     * @return 结果
     */
    @Override
    public Long insertFamilyFeeType(FamilyFeeType familyFeeType)
    {
        familyFeeType.setCreateUser(ShiroUtils.getLoginName());
        familyFeeTypeMapper.insertFamilyFeeType(familyFeeType);
        return familyFeeType.getId();
    }

    /**
     * 修改费用类型
     * 
     * @param familyFeeType 费用类型
     * @return 结果
     */
    @Override
    public int updateFamilyFeeType(FamilyFeeType familyFeeType)
    {
        return familyFeeTypeMapper.updateFamilyFeeType(familyFeeType);
    }

    /**
     * 批量删除费用类型
     * 
     * @param ids 需要删除的费用类型主键
     * @return 结果
     */
    @Override
    public int deleteFamilyFeeTypeByIds(String ids)
    {
        return familyFeeTypeMapper.deleteFamilyFeeTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除费用类型信息
     * 
     * @param id 费用类型主键
     * @return 结果
     */
    @Override
    public int deleteFamilyFeeTypeById(Long id)
    {
        return familyFeeTypeMapper.deleteFamilyFeeTypeById(id);
    }

    @Override
    public void refresh() {
        //支出
        List<SysDictData> pays = sysDictDataMapper.selectDictDataByType("budget_type");
        //收入
        List<SysDictData> incomes = sysDictDataMapper.selectDictDataByType("income_type");
        List<FamilyFeeType> familyFeeTypes = familyFeeTypeMapper.selectFamilyFeeTypeList(null);
        refreshDetails(pays, familyFeeTypes, "支出");
        refreshDetails(incomes, familyFeeTypes, "收入");
    }

    private void refreshDetails(List<SysDictData> pays, List<FamilyFeeType> familyFeeTypes, String 支出) {
        for (SysDictData pay : pays) {
            String dictType = pay.getDictType();
            String dictValue = pay.getDictValue();
            FamilyFeeType familyFeeType = new FamilyFeeType();

            familyFeeType.setDictLabel(pay.getDictLabel());
            familyFeeType.setDictSort(pay.getDictSort());
            familyFeeType.setDictType(pay.getDictType());
            familyFeeType.setDictTypeName(支出);
            familyFeeType.setDictValue(pay.getDictValue());
            if (CollectionUtils.isNotEmpty(familyFeeTypes)) {
                List<FamilyFeeType> collect = familyFeeTypes.stream().filter(r -> r.getDictValue().equals(dictValue) && r.getDictType().equals(dictType)).collect(Collectors.toList());
                if (collect.size() > 0) {
                    familyFeeType.setId(collect.get(0).getId());
                    familyFeeTypeMapper.updateFamilyFeeType(familyFeeType);
                } else {
                    familyFeeType.setControlFlag("0");
                    familyFeeTypeMapper.insertFamilyFeeType(familyFeeType);
                }
            } else {
                familyFeeType.setControlFlag("0");
                familyFeeTypeMapper.insertFamilyFeeType(familyFeeType);
            }
        }
    }
}
