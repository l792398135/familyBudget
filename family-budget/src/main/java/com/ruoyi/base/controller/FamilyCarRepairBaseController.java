package com.ruoyi.base.controller;

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
import com.ruoyi.base.domain.FamilyCarRepairBase;
import com.ruoyi.base.service.IFamilyCarRepairBaseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆保养科目Controller
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
@Controller
@RequestMapping("/base/carRepair")
public class FamilyCarRepairBaseController extends BaseController
{
    private String prefix = "base/carRepair";

    @Autowired
    private IFamilyCarRepairBaseService familyCarRepairBaseService;

    @RequiresPermissions("base:carRepair:view")
    @GetMapping()
    public String carRepair()
    {
        return prefix + "/carRepair";
    }

    /**
     * 查询车辆保养科目列表
     */
    @RequiresPermissions("base:carRepair:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyCarRepairBase familyCarRepairBase)
    {
        startPage();
        List<FamilyCarRepairBase> list = familyCarRepairBaseService.selectFamilyCarRepairBaseList(familyCarRepairBase);
        return getDataTable(list);
    }

    /**
     * 导出车辆保养科目列表
     */
    @RequiresPermissions("base:carRepair:export")
    @Log(title = "车辆保养科目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyCarRepairBase familyCarRepairBase)
    {
        List<FamilyCarRepairBase> list = familyCarRepairBaseService.selectFamilyCarRepairBaseList(familyCarRepairBase);
        ExcelUtil<FamilyCarRepairBase> util = new ExcelUtil<FamilyCarRepairBase>(FamilyCarRepairBase.class);
        return util.exportExcel(list, "车辆保养科目数据");
    }

    /**
     * 新增车辆保养科目
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆保养科目
     */
    @RequiresPermissions("base:carRepair:add")
    @Log(title = "车辆保养科目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyCarRepairBase familyCarRepairBase)
    {
        return AjaxResult.success("success",familyCarRepairBaseService.insertFamilyCarRepairBase(familyCarRepairBase));
    }

    /**
     * 修改车辆保养科目
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyCarRepairBase familyCarRepairBase = familyCarRepairBaseService.selectFamilyCarRepairBaseById(id);
        mmap.put("familyCarRepairBase", familyCarRepairBase);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆保养科目
     */
    @RequiresPermissions("base:carRepair:edit")
    @Log(title = "车辆保养科目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyCarRepairBase familyCarRepairBase)
    {
        return toAjax(familyCarRepairBaseService.updateFamilyCarRepairBase(familyCarRepairBase));
    }

    /**
     * 删除车辆保养科目
     */
    @RequiresPermissions("base:carRepair:remove")
    @Log(title = "车辆保养科目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyCarRepairBaseService.deleteFamilyCarRepairBaseByIds(ids));
    }

    @PostMapping("/refresh")
    @ResponseBody
    public AjaxResult refresh(FamilyCarRepairBase familyCarRepairBase)
    {
        familyCarRepairBaseService.refresh(familyCarRepairBase.getCarCode());
        return AjaxResult.success();
    }
}
