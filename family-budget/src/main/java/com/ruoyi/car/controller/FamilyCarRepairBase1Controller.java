package com.ruoyi.car.controller;

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
import com.ruoyi.car.domain.FamilyCarRepairBase1;
import com.ruoyi.car.service.IFamilyCarRepairBase1Service;
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
@RequestMapping("/car/carRepair")
public class FamilyCarRepairBase1Controller extends BaseController
{
    private String prefix = "car/carRepair";

    @Autowired
    private IFamilyCarRepairBase1Service familyCarRepairBase1Service;

    @RequiresPermissions("car:carRepair:view")
    @GetMapping()
    public String carRepair()
    {
        return prefix + "/carRepair";
    }

    /**
     * 查询车辆保养科目列表
     */
    @RequiresPermissions("car:carRepair:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyCarRepairBase1 familyCarRepairBase1)
    {
        startPage();
        List<FamilyCarRepairBase1> list = familyCarRepairBase1Service.selectFamilyCarRepairBase1List(familyCarRepairBase1);
        return getDataTable(list);
    }

    /**
     * 导出车辆保养科目列表
     */
    @RequiresPermissions("car:carRepair:export")
    @Log(title = "车辆保养科目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyCarRepairBase1 familyCarRepairBase1)
    {
        List<FamilyCarRepairBase1> list = familyCarRepairBase1Service.selectFamilyCarRepairBase1List(familyCarRepairBase1);
        ExcelUtil<FamilyCarRepairBase1> util = new ExcelUtil<FamilyCarRepairBase1>(FamilyCarRepairBase1.class);
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
    @RequiresPermissions("car:carRepair:add")
    @Log(title = "车辆保养科目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyCarRepairBase1 familyCarRepairBase1)
    {
        return AjaxResult.success("success",familyCarRepairBase1Service.insertFamilyCarRepairBase1(familyCarRepairBase1));
    }

    /**
     * 修改车辆保养科目
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyCarRepairBase1 familyCarRepairBase1 = familyCarRepairBase1Service.selectFamilyCarRepairBase1ById(id);
        mmap.put("familyCarRepairBase1", familyCarRepairBase1);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆保养科目
     */
    @RequiresPermissions("car:carRepair:edit")
    @Log(title = "车辆保养科目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyCarRepairBase1 familyCarRepairBase1)
    {
        return toAjax(familyCarRepairBase1Service.updateFamilyCarRepairBase1(familyCarRepairBase1));
    }

    /**
     * 删除车辆保养科目
     */
    @RequiresPermissions("car:carRepair:remove")
    @Log(title = "车辆保养科目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyCarRepairBase1Service.deleteFamilyCarRepairBase1ByIds(ids));
    }

    @GetMapping("/repair/{id}")
    public String repair(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("repair", familyCarRepairBase1Service.selectFamilyCarRepairBase1ById(id));
        return "car/carRepair/repair";
    }
}
