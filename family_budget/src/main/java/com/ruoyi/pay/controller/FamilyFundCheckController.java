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
import com.ruoyi.pay.domain.FamilyFundCheck;
import com.ruoyi.pay.service.IFamilyFundCheckService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 盘点Controller
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
@Controller
@RequestMapping("/cost/check")
public class FamilyFundCheckController extends BaseController
{
    private String prefix = "cost/check";

    @Autowired
    private IFamilyFundCheckService familyFundCheckService;

    @RequiresPermissions("cost:check:view")
    @GetMapping()
    public String check()
    {
        return prefix + "/check";
    }

    /**
     * 查询盘点列表
     */
    @RequiresPermissions("cost:check:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyFundCheck familyFundCheck)
    {
        startPage();
        List<FamilyFundCheck> list = familyFundCheckService.selectFamilyFundCheckList(familyFundCheck);
        return getDataTable(list);
    }

    /**
     * 导出盘点列表
     */
    @RequiresPermissions("cost:check:export")
    @Log(title = "盘点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyFundCheck familyFundCheck)
    {
        List<FamilyFundCheck> list = familyFundCheckService.selectFamilyFundCheckList(familyFundCheck);
        ExcelUtil<FamilyFundCheck> util = new ExcelUtil<FamilyFundCheck>(FamilyFundCheck.class);
        return util.exportExcel(list, "盘点数据");
    }

    /**
     * 新增盘点
     */
    @GetMapping("/add")
    public String add()
    {

        return prefix + "/add";
    }

    /**
     * 新增保存盘点
     */
    @RequiresPermissions("cost:check:add")
    @Log(title = "盘点", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyFundCheck familyFundCheck)
    {
        return toAjax(familyFundCheckService.insertFamilyFundCheck(familyFundCheck));
    }

    /**
     * 修改盘点
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyFundCheck familyFundCheck = familyFundCheckService.selectFamilyFundCheckById(id);
        mmap.put("familyFundCheck", familyFundCheck);
        return prefix + "/edit";
    }

    /**
     * 修改保存盘点
     */
    @RequiresPermissions("cost:check:edit")
    @Log(title = "盘点", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyFundCheck familyFundCheck)
    {
        return toAjax(familyFundCheckService.updateFamilyFundCheck(familyFundCheck));
    }

    /**
     * 删除盘点
     */
    @RequiresPermissions("cost:check:remove")
    @Log(title = "盘点", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyFundCheckService.deleteFamilyFundCheckByIds(ids));
    }

    @RequiresPermissions("cost:check:remove")
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("check", familyFundCheckService.selectCheckById(id));
//        mmap.put("dictList", dictTypeService.selectDictTypeAll());
        return "cost/checkdetails/checkdetails";
    }
}
