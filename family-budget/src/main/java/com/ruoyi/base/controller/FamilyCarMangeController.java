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
import com.ruoyi.base.domain.FamilyCarMange;
import com.ruoyi.base.service.IFamilyCarMangeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆管理基础数据Controller
 * 
 * @author ruoyi
 * @date 2021-10-26
 */
@Controller
@RequestMapping("/base/carMange")
public class FamilyCarMangeController extends BaseController
{
    private String prefix = "base/carMange";

    @Autowired
    private IFamilyCarMangeService familyCarMangeService;

    @RequiresPermissions("base:carMange:view")
    @GetMapping()
    public String carMange()
    {
        return prefix + "/carMange";
    }

    /**
     * 查询车辆管理基础数据列表
     */
    @RequiresPermissions("base:carMange:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyCarMange familyCarMange)
    {
        startPage();
        List<FamilyCarMange> list = familyCarMangeService.selectFamilyCarMangeList(familyCarMange);
        return getDataTable(list);
    }

    /**
     * 导出车辆管理基础数据列表
     */
    @RequiresPermissions("base:carMange:export")
    @Log(title = "车辆管理基础数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyCarMange familyCarMange)
    {
        List<FamilyCarMange> list = familyCarMangeService.selectFamilyCarMangeList(familyCarMange);
        ExcelUtil<FamilyCarMange> util = new ExcelUtil<FamilyCarMange>(FamilyCarMange.class);
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
    @RequiresPermissions("base:carMange:add")
    @Log(title = "车辆管理基础数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyCarMange familyCarMange)
    {
        return AjaxResult.success("success",familyCarMangeService.insertFamilyCarMange(familyCarMange));
    }

    /**
     * 修改车辆管理基础数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyCarMange familyCarMange = familyCarMangeService.selectFamilyCarMangeById(id);
        mmap.put("familyCarMange", familyCarMange);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆管理基础数据
     */
    @RequiresPermissions("base:carMange:edit")
    @Log(title = "车辆管理基础数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyCarMange familyCarMange)
    {
        return toAjax(familyCarMangeService.updateFamilyCarMange(familyCarMange));
    }

    /**
     * 删除车辆管理基础数据
     */
    @RequiresPermissions("base:carMange:remove")
    @Log(title = "车辆管理基础数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyCarMangeService.deleteFamilyCarMangeByIds(ids));
    }
}
