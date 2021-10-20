package com.ruoyi.pay.controller;

import java.util.List;

import com.ruoyi.search.controller.FamilyReportController;
import com.ruoyi.search.service.impl.FamilyReportServiceImpl;
import com.ruoyi.search.vo.ChartVO;
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
import com.ruoyi.pay.domain.FamilyMonthBudgetDetails;
import com.ruoyi.pay.service.IFamilyMonthBudgetDetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预算明细Controller
 * 
 * @author ruoyi
 * @date 2021-10-19
 */
@Controller
@RequestMapping("/budget/budgetDetails")
public class FamilyMonthBudgetDetailsController extends BaseController
{
    private String prefix = "budget/budgetDetails";

    @Autowired
    private IFamilyMonthBudgetDetailsService familyMonthBudgetDetailsService;
    @Autowired
    private FamilyReportServiceImpl reportService;

    @RequiresPermissions("budget:budgetDetails:view")
    @GetMapping()
    public String budgetDetails()
    {
        return prefix + "/budgetDetails";
    }

    /**
     * 查询预算明细列表
     */
    @RequiresPermissions("budget:budgetDetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyMonthBudgetDetails familyMonthBudgetDetails)
    {
        startPage();
        List<FamilyMonthBudgetDetails> list = familyMonthBudgetDetailsService.selectFamilyMonthBudgetDetailsList(familyMonthBudgetDetails);
        return getDataTable(list);
    }

    /**
     * 导出预算明细列表
     */
    @RequiresPermissions("budget:budgetDetails:export")
    @Log(title = "预算明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyMonthBudgetDetails familyMonthBudgetDetails)
    {
        List<FamilyMonthBudgetDetails> list = familyMonthBudgetDetailsService.selectFamilyMonthBudgetDetailsList(familyMonthBudgetDetails);
        ExcelUtil<FamilyMonthBudgetDetails> util = new ExcelUtil<FamilyMonthBudgetDetails>(FamilyMonthBudgetDetails.class);
        return util.exportExcel(list, "预算明细数据");
    }

    /**
     * 新增预算明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存预算明细
     */
    @RequiresPermissions("budget:budgetDetails:add")
    @Log(title = "预算明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyMonthBudgetDetails familyMonthBudgetDetails)
    {
        return AjaxResult.success("success",familyMonthBudgetDetailsService.insertFamilyMonthBudgetDetails(familyMonthBudgetDetails));
    }

    /**
     * 修改预算明细
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyMonthBudgetDetails familyMonthBudgetDetails = familyMonthBudgetDetailsService.selectFamilyMonthBudgetDetailsById(id);
        mmap.put("familyMonthBudgetDetails", familyMonthBudgetDetails);
        String typeName = familyMonthBudgetDetails.getDictTypeName();
        String label = familyMonthBudgetDetails.getDictLabel();
        mmap.put("chartTitle",label+"的"+typeName);
        return prefix + "/edit";
    }

    /**
     * 修改保存预算明细
     */
    @RequiresPermissions("budget:budgetDetails:edit")
    @Log(title = "预算明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyMonthBudgetDetails familyMonthBudgetDetails)
    {
        return toAjax(familyMonthBudgetDetailsService.updateFamilyMonthBudgetDetails(familyMonthBudgetDetails));
    }

    /**
     * 删除预算明细
     */
    @RequiresPermissions("budget:budgetDetails:remove")
    @Log(title = "预算明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyMonthBudgetDetailsService.deleteFamilyMonthBudgetDetailsByIds(ids));
    }


}
