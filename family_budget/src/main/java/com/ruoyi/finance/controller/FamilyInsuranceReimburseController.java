package com.ruoyi.finance.controller;

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
import com.ruoyi.finance.domain.FamilyInsuranceReimburse;
import com.ruoyi.finance.service.IFamilyInsuranceReimburseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 保险报销Controller
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
@Controller
@RequestMapping("/system/reimburse")
public class FamilyInsuranceReimburseController extends BaseController
{
    private String prefix = "system/reimburse";

    @Autowired
    private IFamilyInsuranceReimburseService familyInsuranceReimburseService;

    @RequiresPermissions("system:reimburse:view")
    @GetMapping()
    public String reimburse()
    {
        return prefix + "/reimburse";
    }

    /**
     * 查询保险报销列表
     */
    @RequiresPermissions("system:reimburse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyInsuranceReimburse familyInsuranceReimburse)
    {
        startPage();
        List<FamilyInsuranceReimburse> list = familyInsuranceReimburseService.selectFamilyInsuranceReimburseList(familyInsuranceReimburse);
        return getDataTable(list);
    }

    /**
     * 导出保险报销列表
     */
    @RequiresPermissions("system:reimburse:export")
    @Log(title = "保险报销", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyInsuranceReimburse familyInsuranceReimburse)
    {
        List<FamilyInsuranceReimburse> list = familyInsuranceReimburseService.selectFamilyInsuranceReimburseList(familyInsuranceReimburse);
        ExcelUtil<FamilyInsuranceReimburse> util = new ExcelUtil<FamilyInsuranceReimburse>(FamilyInsuranceReimburse.class);
        return util.exportExcel(list, "保险报销数据");
    }

    /**
     * 新增保险报销
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存保险报销
     */
    @RequiresPermissions("system:reimburse:add")
    @Log(title = "保险报销", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyInsuranceReimburse familyInsuranceReimburse)
    {
        return toAjax(familyInsuranceReimburseService.insertFamilyInsuranceReimburse(familyInsuranceReimburse));
    }

    /**
     * 修改保险报销
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyInsuranceReimburse familyInsuranceReimburse = familyInsuranceReimburseService.selectFamilyInsuranceReimburseById(id);
        mmap.put("familyInsuranceReimburse", familyInsuranceReimburse);
        return prefix + "/edit";
    }

    /**
     * 修改保存保险报销
     */
    @RequiresPermissions("system:reimburse:edit")
    @Log(title = "保险报销", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyInsuranceReimburse familyInsuranceReimburse)
    {
        return toAjax(familyInsuranceReimburseService.updateFamilyInsuranceReimburse(familyInsuranceReimburse));
    }

    /**
     * 删除保险报销
     */
    @RequiresPermissions("system:reimburse:remove")
    @Log(title = "保险报销", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyInsuranceReimburseService.deleteFamilyInsuranceReimburseByIds(ids));
    }
}
