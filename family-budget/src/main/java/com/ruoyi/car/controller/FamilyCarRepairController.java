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
import com.ruoyi.car.domain.FamilyCarRepair;
import com.ruoyi.car.service.IFamilyCarRepairService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆维护费用Controller
 * 
 * @author ruoyi
 * @date 2021-10-30
 */
@Controller
@RequestMapping("/car/cost")
public class FamilyCarRepairController extends BaseController
{
    private String prefix = "car/cost";

    @Autowired
    private IFamilyCarRepairService familyCarRepairService;

    @RequiresPermissions("car:cost:view")
    @GetMapping()
    public String cost()
    {
        return prefix + "/cost";
    }

    /**
     * 查询车辆维护费用列表
     */
    @RequiresPermissions("car:cost:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyCarRepair familyCarRepair)
    {
        startPage();
        List<FamilyCarRepair> list = familyCarRepairService.selectFamilyCarRepairList(familyCarRepair);
        return getDataTable(list);
    }

    /**
     * 导出车辆维护费用列表
     */
    @RequiresPermissions("car:cost:export")
    @Log(title = "车辆维护费用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyCarRepair familyCarRepair)
    {
        List<FamilyCarRepair> list = familyCarRepairService.selectFamilyCarRepairList(familyCarRepair);
        ExcelUtil<FamilyCarRepair> util = new ExcelUtil<FamilyCarRepair>(FamilyCarRepair.class);
        return util.exportExcel(list, "车辆维护费用数据");
    }

    /**
     * 新增车辆维护费用
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆维护费用
     */
    @RequiresPermissions("car:cost:add")
    @Log(title = "车辆维护费用", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyCarRepair familyCarRepair)
    {
        return AjaxResult.success("success",familyCarRepairService.insertFamilyCarRepair(familyCarRepair));
    }

    /**
     * 修改车辆维护费用
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyCarRepair familyCarRepair = familyCarRepairService.selectFamilyCarRepairById(id);
        mmap.put("familyCarRepair", familyCarRepair);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆维护费用
     */
    @RequiresPermissions("car:cost:edit")
    @Log(title = "车辆维护费用", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyCarRepair familyCarRepair)
    {
        return toAjax(familyCarRepairService.updateFamilyCarRepair(familyCarRepair));
    }

    /**
     * 删除车辆维护费用
     */
    @RequiresPermissions("car:cost:remove")
    @Log(title = "车辆维护费用", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyCarRepairService.deleteFamilyCarRepairByIds(ids));
    }
}
