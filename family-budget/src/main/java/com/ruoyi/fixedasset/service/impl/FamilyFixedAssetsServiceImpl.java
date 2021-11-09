package com.ruoyi.fixedasset.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.mapper.SysAttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fixedasset.mapper.FamilyFixedAssetsMapper;
import com.ruoyi.fixedasset.domain.FamilyFixedAssets;
import com.ruoyi.fixedasset.service.IFamilyFixedAssetsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 固定资产Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Service
public class FamilyFixedAssetsServiceImpl implements IFamilyFixedAssetsService 
{
    @Autowired
    private FamilyFixedAssetsMapper familyFixedAssetsMapper;

    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;
    /**
     * 查询固定资产
     * 
     * @param id 固定资产主键
     * @return 固定资产
     */
    @Override
    public FamilyFixedAssets selectFamilyFixedAssetsById(Long id)
    {
        return familyFixedAssetsMapper.selectFamilyFixedAssetsById(id);
    }

    /**
     * 查询固定资产列表
     * 
     * @param familyFixedAssets 固定资产
     * @return 固定资产
     */
    @Override
    public List<FamilyFixedAssets> selectFamilyFixedAssetsList(FamilyFixedAssets familyFixedAssets)
    {
        List<FamilyFixedAssets> familyFixedAssets1 = familyFixedAssetsMapper.selectFamilyFixedAssetsList(familyFixedAssets);
            for (int i = 0; i <familyFixedAssets1.size() ; i++) {
                FamilyFixedAssets fixedAssets =familyFixedAssets1.get(i);
                Long id = fixedAssets.getId();
                SysAttachment sysAttachment = new SysAttachment();
                sysAttachment.setBusinessId(String.valueOf(id));
                sysAttachment.setBusinessType("budgetassets");
                sysAttachment.setDelFlag(0);
                List<SysAttachment> sysAttachments = sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
                if (sysAttachments!=null) {
                    List<String> collect = sysAttachments.stream().map(r -> r.getFilePath()).collect(Collectors.toList());
                    fixedAssets.setImgUrls(collect);
                }
                familyFixedAssets1.set(i,fixedAssets);
            }
        return familyFixedAssets1;
    }

    /**
     * 新增固定资产
     * 
     * @param familyFixedAssets 固定资产
     * @return 结果
     */
    @Override
    public Long insertFamilyFixedAssets(FamilyFixedAssets familyFixedAssets)
    {
        familyFixedAssets.setNowCost(familyFixedAssets.getBuyCost());
        familyFixedAssets.setNowEditDate(familyFixedAssets.getBuyDate());
        int i = familyFixedAssetsMapper.insertFamilyFixedAssets(familyFixedAssets);
        Long id = familyFixedAssets.getId();
        return id;
    }

    /**
     * 修改固定资产
     * 
     * @param familyFixedAssets 固定资产
     * @return 结果
     */
    @Override
    public int updateFamilyFixedAssets(FamilyFixedAssets familyFixedAssets)
    {
        return familyFixedAssetsMapper.updateFamilyFixedAssets(familyFixedAssets);
    }

    /**
     * 批量删除固定资产
     * 
     * @param ids 需要删除的固定资产主键
     * @return 结果
     */
    @Override
    public int deleteFamilyFixedAssetsByIds(String ids)
    {
        return familyFixedAssetsMapper.deleteFamilyFixedAssetsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除固定资产信息
     * 
     * @param id 固定资产主键
     * @return 结果
     */
    @Override
    public int deleteFamilyFixedAssetsById(Long id)
    {
        return familyFixedAssetsMapper.deleteFamilyFixedAssetsById(id);
    }
}
