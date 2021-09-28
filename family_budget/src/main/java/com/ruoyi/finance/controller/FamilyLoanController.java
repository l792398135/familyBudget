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
import com.ruoyi.finance.domain.FamilyLoan;
import com.ruoyi.finance.service.IFamilyLoanService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 负债Controller
 * 
 * @author ruoyi
 * @date 2021-09-28
 */
@Controller
@RequestMapping("/finance/loan")
public class FamilyLoanController extends BaseController
{
    private String prefix = "finance/loan";

    @Autowired
    private IFamilyLoanService familyLoanService;

    @RequiresPermissions("finance:loan:view")
    @GetMapping()
    public String loan()
    {
        return prefix + "/loan";
    }

    /**
     * 查询负债列表
     */
    @RequiresPermissions("finance:loan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyLoan familyLoan)
    {
        startPage();
        List<FamilyLoan> list = familyLoanService.selectFamilyLoanList(familyLoan);
        return getDataTable(list);
    }

    /**
     * 导出负债列表
     */
    @RequiresPermissions("finance:loan:export")
    @Log(title = "负债", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyLoan familyLoan)
    {
        List<FamilyLoan> list = familyLoanService.selectFamilyLoanList(familyLoan);
        ExcelUtil<FamilyLoan> util = new ExcelUtil<FamilyLoan>(FamilyLoan.class);
        return util.exportExcel(list, "负债数据");
    }

    /**
     * 新增负债
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存负债
     */
    @RequiresPermissions("finance:loan:add")
    @Log(title = "负债", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyLoan familyLoan)
    {
        return AjaxResult.success("success",familyLoanService.insertFamilyLoan(familyLoan));
    }

    /**
     * 修改负债
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyLoan familyLoan = familyLoanService.selectFamilyLoanById(id);
        mmap.put("familyLoan", familyLoan);
        return prefix + "/edit";
    }

    /**
     * 修改保存负债
     */
    @RequiresPermissions("finance:loan:edit")
    @Log(title = "负债", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyLoan familyLoan)
    {
        return toAjax(familyLoanService.updateFamilyLoan(familyLoan));
    }

    /**
     * 删除负债
     */
    @RequiresPermissions("finance:loan:remove")
    @Log(title = "负债", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyLoanService.deleteFamilyLoanByIds(ids));
    }
}
