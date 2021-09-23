package com.ruoyi.pay.controller;

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
import com.ruoyi.pay.domain.FamilyCheckDetails;
import com.ruoyi.pay.service.IFamilyCheckDetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 盘点详情Controller
 * 
 * @author ruoyi
 * @date 2021-09-23
 */
@Controller
@RequestMapping("/cost/checkdetails")
public class FamilyCheckDetailsController extends BaseController
{
    private String prefix = "cost/checkdetails";

    @Autowired
    private IFamilyCheckDetailsService familyCheckDetailsService;

    @RequiresPermissions("cost:checkdetails:view")
    @GetMapping()
    public String checkdetails()
    {
        return prefix + "/checkdetails";
    }

    /**
     * 查询盘点详情列表
     */
    @RequiresPermissions("cost:checkdetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyCheckDetails familyCheckDetails)
    {
        startPage();
        List<FamilyCheckDetails> list = familyCheckDetailsService.selectFamilyCheckDetailsList(familyCheckDetails);
        return getDataTable(list);
    }

    /**
     * 导出盘点详情列表
     */
    @RequiresPermissions("cost:checkdetails:export")
    @Log(title = "盘点详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyCheckDetails familyCheckDetails)
    {
        List<FamilyCheckDetails> list = familyCheckDetailsService.selectFamilyCheckDetailsList(familyCheckDetails);
        ExcelUtil<FamilyCheckDetails> util = new ExcelUtil<FamilyCheckDetails>(FamilyCheckDetails.class);
        return util.exportExcel(list, "盘点详情数据");
    }

    /**
     * 新增盘点详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存盘点详情
     */
    @RequiresPermissions("cost:checkdetails:add")
    @Log(title = "盘点详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyCheckDetails familyCheckDetails)
    {
        return toAjax(familyCheckDetailsService.insertFamilyCheckDetails(familyCheckDetails));
    }

    /**
     * 修改盘点详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyCheckDetails familyCheckDetails = familyCheckDetailsService.selectFamilyCheckDetailsById(id);
        mmap.put("familyCheckDetails", familyCheckDetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存盘点详情
     */
    @RequiresPermissions("cost:checkdetails:edit")
    @Log(title = "盘点详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyCheckDetails familyCheckDetails)
    {
        return toAjax(familyCheckDetailsService.updateFamilyCheckDetails(familyCheckDetails));
    }

    /**
     * 删除盘点详情
     */
    @RequiresPermissions("cost:checkdetails:remove")
    @Log(title = "盘点详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyCheckDetailsService.deleteFamilyCheckDetailsByIds(ids));
    }
}
