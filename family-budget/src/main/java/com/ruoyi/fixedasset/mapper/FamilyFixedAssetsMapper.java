package com.ruoyi.fixedasset.mapper;

import java.util.List;
import com.ruoyi.fixedasset.domain.FamilyFixedAssets;

/**
 * 固定资产Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
public interface FamilyFixedAssetsMapper 
{
    /**
     * 查询固定资产
     * 
     * @param id 固定资产主键
     * @return 固定资产
     */
    public FamilyFixedAssets selectFamilyFixedAssetsById(Long id);

    /**
     * 查询固定资产列表
     * 
     * @param familyFixedAssets 固定资产
     * @return 固定资产集合
     */
    public List<FamilyFixedAssets> selectFamilyFixedAssetsList(FamilyFixedAssets familyFixedAssets);

    /**
     * 新增固定资产
     * 
     * @param familyFixedAssets 固定资产
     * @return 结果
     */
    public int insertFamilyFixedAssets(FamilyFixedAssets familyFixedAssets);

    /**
     * 修改固定资产
     * 
     * @param familyFixedAssets 固定资产
     * @return 结果
     */
    public int updateFamilyFixedAssets(FamilyFixedAssets familyFixedAssets);

    /**
     * 删除固定资产
     * 
     * @param id 固定资产主键
     * @return 结果
     */
    public int deleteFamilyFixedAssetsById(Long id);

    /**
     * 批量删除固定资产
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFamilyFixedAssetsByIds(String[] ids);
}
