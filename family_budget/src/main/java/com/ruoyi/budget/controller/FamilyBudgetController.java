package com.ruoyi.budget.controller;

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
import com.ruoyi.budget.domain.FamilyBudget;
import com.ruoyi.budget.service.IFamilyBudgetService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预算Controller
 * 
 * @author ruoyi
 * @date 2021-09-09
 */
@Controller
@RequestMapping("/familybudget/budget")
public class FamilyBudgetController extends BaseController
{
    private String prefix = "familybudget/budget";

    @Autowired
    private IFamilyBudgetService familyBudgetService;

    @RequiresPermissions("familybudget:budget:view")
    @GetMapping()
    public String budget()
    {
        return prefix + "/budget";
    }

    /**
     * 查询预算列表
     */
    @RequiresPermissions("familybudget:budget:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyBudget familyBudget)
    {
        startPage();
        List<FamilyBudget> list = familyBudgetService.selectFamilyBudgetList(familyBudget);
        return getDataTable(list);
    }

    /**
     * 导出预算列表
     */
    @RequiresPermissions("familybudget:budget:export")
    @Log(title = "预算", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyBudget familyBudget)
    {
        List<FamilyBudget> list = familyBudgetService.selectFamilyBudgetList(familyBudget);
        ExcelUtil<FamilyBudget> util = new ExcelUtil<FamilyBudget>(FamilyBudget.class);
        return util.exportExcel(list, "预算数据");
    }

    /**
     * 新增预算
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存预算
     */
    @RequiresPermissions("familybudget:budget:add")
    @Log(title = "预算", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyBudget familyBudget)
    {
        return toAjax(familyBudgetService.insertFamilyBudget(familyBudget));
    }

    /**
     * 修改预算
     */
    @GetMapping("/edit/{familyMemberCode}")
    public String edit(@PathVariable("familyMemberCode") String familyMemberCode, ModelMap mmap)
    {
        FamilyBudget familyBudget = familyBudgetService.selectFamilyBudgetByFamilyMemberCode(familyMemberCode);
        mmap.put("familyBudget", familyBudget);
        return prefix + "/edit";
    }

    /**
     * 修改保存预算
     */
    @RequiresPermissions("familybudget:budget:edit")
    @Log(title = "预算", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyBudget familyBudget)
    {
        return toAjax(familyBudgetService.updateFamilyBudget(familyBudget));
    }

    /**
     * 删除预算
     */
    @RequiresPermissions("familybudget:budget:remove")
    @Log(title = "预算", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyBudgetService.deleteFamilyBudgetByFamilyMemberCodes(ids));
    }
}
