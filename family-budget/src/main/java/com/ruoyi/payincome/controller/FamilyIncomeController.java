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
import com.ruoyi.payincome.domain.FamilyIncome;
import com.ruoyi.payincome.service.IFamilyIncomeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 家庭收入Controller
 * 
 * @author 刘兴武
 * @date 2021-09-10
 */
@Controller
@RequestMapping("/cost/income")
public class FamilyIncomeController extends BaseController
{
    private String prefix = "cost/income";

    @Autowired
    private IFamilyIncomeService familyIncomeService;

    @RequiresPermissions("cost:income:view")
    @GetMapping()
    public String income()
    {
        return prefix + "/income";
    }

    /**
     * 查询家庭收入列表
     */
    @RequiresPermissions("cost:income:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyIncome familyIncome)
    {
        startPage();
        List<FamilyIncome> list = familyIncomeService.selectFamilyIncomeList(familyIncome);
        return getDataTable(list);
    }

    /**
     * 新增家庭收入
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存家庭收入
     */
    @RequiresPermissions("cost:income:add")
    @Log(title = "家庭收入", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyIncome familyIncome)
    {
        return toAjax(familyIncomeService.insertFamilyIncome(familyIncome));
    }

    /**
     * 修改家庭收入
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyIncome familyIncome = familyIncomeService.selectFamilyIncomeById(id);
        mmap.put("familyIncome", familyIncome);
        return prefix + "/edit";
    }

    /**
     * 修改保存家庭收入
     */
    @RequiresPermissions("cost:income:edit")
    @Log(title = "家庭收入", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyIncome familyIncome)
    {
        return toAjax(familyIncomeService.updateFamilyIncome(familyIncome));
    }

    /**
     * 删除家庭收入
     */
    @RequiresPermissions("cost:income:remove")
    @Log(title = "家庭收入", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyIncomeService.deleteFamilyIncomeByIds(ids));
    }
}
