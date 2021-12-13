package com.ruoyi.payincome.controller;

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
import com.ruoyi.payincome.domain.FamilyMonthBudget;
import com.ruoyi.payincome.service.IFamilyMonthBudgetService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 月预算Controller
 * 
 * @author ruoyi
 * @date 2021-09-14
 */
@Controller
@RequestMapping("/budget/budget")
public class FamilyMonthBudgetController extends BaseController
{
    private String prefix = "budget/budget";

    @Autowired
    private IFamilyMonthBudgetService familyMonthBudgetService;

    @RequiresPermissions("budget:budget:view")
    @GetMapping()
    public String budget()
    {
        return prefix + "/budget";
    }

    /**
     * 查询月预算列表
     */
    @RequiresPermissions("budget:budget:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyMonthBudget familyMonthBudget)
    {
        startPage();
        List<FamilyMonthBudget> list = familyMonthBudgetService.selectFamilyMonthBudgetList(familyMonthBudget);
        return getDataTable(list);
    }


    /**
     * 新增月预算
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存月预算
     */
    @RequiresPermissions("budget:budget:add")
    @Log(title = "月预算", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyMonthBudget familyMonthBudget)
    {
        return toAjax(familyMonthBudgetService.insertFamilyMonthBudget(familyMonthBudget));
    }

    /**
     * 修改月预算
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyMonthBudget familyMonthBudget = familyMonthBudgetService.selectFamilyMonthBudgetById(id);
        mmap.put("familyMonthBudget", familyMonthBudget);
        return prefix + "/edit";
    }

    /**
     * 修改保存月预算
     */
    @RequiresPermissions("budget:budget:edit")
    @Log(title = "月预算", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyMonthBudget familyMonthBudget)
    {
        return toAjax(familyMonthBudgetService.updateFamilyMonthBudget(familyMonthBudget));
    }

    /**
     * 删除月预算
     */
    @RequiresPermissions("budget:budget:remove")
    @Log(title = "月预算", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyMonthBudgetService.deleteFamilyMonthBudgetByIds(ids));
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("budget", familyMonthBudgetService.selectFamilyMonthBudgetById(id));
        return "budget/budgetDetails/budgetDetails";
    }
}
