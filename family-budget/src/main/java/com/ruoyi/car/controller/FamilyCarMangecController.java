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
import com.ruoyi.car.domain.FamilyCarMangec;
import com.ruoyi.car.service.IFamilyCarMangecService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆管理基础数据Controller
 * 
 * @author ruoyi
 * @date 2021-10-31
 */
@Controller
@RequestMapping("/car/carMange")
public class FamilyCarMangecController extends BaseController
{
    private String prefix = "car/carMange";

    @Autowired
    private IFamilyCarMangecService familyCarMangecService;

    @RequiresPermissions("car:carMange:view")
    @GetMapping()
    public String carMange()
    {
        return prefix + "/carMange";
    }

    /**
     * 查询车辆管理基础数据列表
     */
    @RequiresPermissions("car:carMange:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyCarMangec familyCarMangec)
    {
        startPage();
        List<FamilyCarMangec> list = familyCarMangecService.selectFamilyCarMangecList(familyCarMangec);
        return getDataTable(list);
    }

    /**
     * 导出车辆管理基础数据列表
     */
    @RequiresPermissions("car:carMange:export")
    @Log(title = "车辆管理基础数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyCarMangec familyCarMangec)
    {
        List<FamilyCarMangec> list = familyCarMangecService.selectFamilyCarMangecList(familyCarMangec);
        ExcelUtil<FamilyCarMangec> util = new ExcelUtil<FamilyCarMangec>(FamilyCarMangec.class);
        return util.exportExcel(list, "车辆管理基础数据数据");
    }

    /**
     * 新增车辆管理基础数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆管理基础数据
     */
    @RequiresPermissions("car:carMange:add")
    @Log(title = "车辆管理基础数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyCarMangec familyCarMangec)
    {
        return AjaxResult.success("success",familyCarMangecService.insertFamilyCarMangec(familyCarMangec));
    }

    /**
     * 修改车辆管理基础数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyCarMangec familyCarMangec = familyCarMangecService.selectFamilyCarMangecById(id);
        mmap.put("familyCarMangec", familyCarMangec);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆管理基础数据
     */
    @RequiresPermissions("car:carMange:edit")
    @Log(title = "车辆管理基础数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyCarMangec familyCarMangec)
    {
        return toAjax(familyCarMangecService.updateFamilyCarMangec(familyCarMangec));
    }

    /**
     * 删除车辆管理基础数据
     */
    @RequiresPermissions("car:carMange:remove")
    @Log(title = "车辆管理基础数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyCarMangecService.deleteFamilyCarMangecByIds(ids));
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("repair", familyCarMangecService.selectFamilyCarMangecById(id));
        return "car/carRepair/carRepair";
    }
}
