package com.ruoyi.fixedasset.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.fixedasset.domain.FamilyFixedAssets;
import com.ruoyi.fixedasset.service.IFamilyFixedAssetsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 固定资产Controller
 * 
 * @author ruoyi
 * @date 2021-09-15
 */
@Controller
@RequestMapping("/budget/assets")
public class FamilyFixedAssetsController extends BaseController
{
    private String prefix = "budget/assets";

    @Autowired
    private IFamilyFixedAssetsService familyFixedAssetsService;

    @RequiresPermissions("budget:assets:view")
    @GetMapping()
    public String assets()
    {
        return prefix + "/assets";
    }

    /**
     * 查询固定资产列表
     */
    @RequiresPermissions("budget:assets:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyFixedAssets familyFixedAssets)
    {
        startPage();
        List<FamilyFixedAssets> list = familyFixedAssetsService.selectFamilyFixedAssetsList(familyFixedAssets);
        return getDataTable(list);
    }

    /**
     * 导出固定资产列表
     */
    @RequiresPermissions("budget:assets:export")
    @Log(title = "固定资产", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyFixedAssets familyFixedAssets)
    {
        List<FamilyFixedAssets> list = familyFixedAssetsService.selectFamilyFixedAssetsList(familyFixedAssets);
        ExcelUtil<FamilyFixedAssets> util = new ExcelUtil<FamilyFixedAssets>(FamilyFixedAssets.class);
        return util.exportExcel(list, "固定资产数据");
    }

    /**
     * 新增固定资产
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存固定资产
     */
    @RequiresPermissions("budget:assets:add")
    @Log(title = "固定资产", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyFixedAssets familyFixedAssets)
    {
        return AjaxResult.success("success",familyFixedAssetsService.insertFamilyFixedAssets(familyFixedAssets));
    }

    /**
     * 修改固定资产
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyFixedAssets familyFixedAssets = familyFixedAssetsService.selectFamilyFixedAssetsById(id);
        mmap.put("familyFixedAssets", familyFixedAssets);
        return prefix + "/edit";
    }

    /**
     * 修改保存固定资产
     */
    @RequiresPermissions("budget:assets:edit")
    @Log(title = "固定资产", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyFixedAssets familyFixedAssets)
    {
        return toAjax(familyFixedAssetsService.updateFamilyFixedAssets(familyFixedAssets));
    }

    /**
     * 删除固定资产
     */
    @RequiresPermissions("budget:assets:remove")
    @Log(title = "固定资产", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyFixedAssetsService.deleteFamilyFixedAssetsByIds(ids));
    }
}
