package com.ruoyi.base.controller;

import java.util.List;

import com.ruoyi.base.domain.FamilyFundCheck2;
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
import com.ruoyi.base.service.IFamilyFundCheck2Service;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 盘点设置Controller
 * 
 * @author ruoyi
 * @date 2021-11-26
 */
@Controller
@RequestMapping("/base/fundCheck")
public class FamilyFundCheck2Controller extends BaseController
{
    private String prefix = "base/fundCheck";

    @Autowired
    private IFamilyFundCheck2Service familyFundCheckService;

    @RequiresPermissions("base:fundCheck:view")
    @GetMapping()
    public String fundCheck()
    {
        return prefix + "/fundCheck";
    }

    /**
     * 查询盘点设置列表
     */
    @RequiresPermissions("base:fundCheck:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyFundCheck2 familyFundCheck2)
    {
        startPage();
        List<FamilyFundCheck2> list = familyFundCheckService.selectFamilyFundCheckList(familyFundCheck2);
        return getDataTable(list);
    }

    /**
     * 导出盘点设置列表
     */
    @RequiresPermissions("base:fundCheck:export")
    @Log(title = "盘点设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyFundCheck2 familyFundCheck2)
    {
        List<FamilyFundCheck2> list = familyFundCheckService.selectFamilyFundCheckList(familyFundCheck2);
        ExcelUtil<FamilyFundCheck2> util = new ExcelUtil<FamilyFundCheck2>(FamilyFundCheck2.class);
        return util.exportExcel(list, "盘点设置数据");
    }

    /**
     * 新增盘点设置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存盘点设置
     */
    @RequiresPermissions("base:fundCheck:add")
    @Log(title = "盘点设置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyFundCheck2 familyFundCheck2)
    {
        return AjaxResult.success("success",familyFundCheckService.insertFamilyFundCheck(familyFundCheck2));
    }

    /**
     * 修改盘点设置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyFundCheck2 familyFundCheck2 = familyFundCheckService.selectFamilyFundCheckById(id);
        mmap.put("familyFundCheck2", familyFundCheck2);
        return prefix + "/edit";
    }

    /**
     * 修改保存盘点设置
     */
    @RequiresPermissions("base:fundCheck:edit")
    @Log(title = "盘点设置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyFundCheck2 familyFundCheck2)
    {
        return toAjax(familyFundCheckService.updateFamilyFundCheck(familyFundCheck2));
    }

    /**
     * 删除盘点设置
     */
    @RequiresPermissions("base:fundCheck:remove")
    @Log(title = "盘点设置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyFundCheckService.deleteFamilyFundCheckByIds(ids));
    }
}
