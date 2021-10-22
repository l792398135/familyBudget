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
import com.ruoyi.finance.domain.FamilyDebt;
import com.ruoyi.finance.service.IFamilyDebtService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 债务Controller
 * 
 * @author ruoyi
 * @date 2021-09-25
 */
@Controller
@RequestMapping("/finance/debt")
public class FamilyDebtController extends BaseController
{
    private String prefix = "finance/debt";

    @Autowired
    private IFamilyDebtService familyDebtService;

    @RequiresPermissions("finance:debt:view")
    @GetMapping()
    public String debt()
    {
        return prefix + "/debt";
    }

    /**
     * 查询债务列表
     */
    @RequiresPermissions("finance:debt:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyDebt familyDebt)
    {
        startPage();
        List<FamilyDebt> list = familyDebtService.selectFamilyDebtList(familyDebt);
        return getDataTable(list);
    }

    /**
     * 导出债务列表
     */
    @RequiresPermissions("finance:debt:export")
    @Log(title = "债务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyDebt familyDebt)
    {
        List<FamilyDebt> list = familyDebtService.selectFamilyDebtList(familyDebt);
        ExcelUtil<FamilyDebt> util = new ExcelUtil<FamilyDebt>(FamilyDebt.class);
        return util.exportExcel(list, "债务数据");
    }

    /**
     * 新增债务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存债务
     */
    @RequiresPermissions("finance:debt:add")
    @Log(title = "债务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyDebt familyDebt)
    {
        return toAjax(familyDebtService.insertFamilyDebt(familyDebt));
    }

    /**
     * 修改债务
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyDebt familyDebt = familyDebtService.selectFamilyDebtById(id);
        mmap.put("familyDebt", familyDebt);
        return prefix + "/edit";
    }

    /**
     * 修改保存债务
     */
    @RequiresPermissions("finance:debt:edit")
    @Log(title = "债务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyDebt familyDebt)
    {
        return toAjax(familyDebtService.updateFamilyDebt(familyDebt));
    }

    /**
     * 删除债务
     */
    @RequiresPermissions("finance:debt:remove")
    @Log(title = "债务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyDebtService.deleteFamilyDebtByIds(ids));
    }
}
