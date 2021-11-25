package com.ruoyi.system.controller;

import java.util.Date;
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
import com.ruoyi.system.domain.FamilyMyTodo;
import com.ruoyi.system.service.IFamilyMyTodoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 首页通知Controller
 * 
 * @author ruoyi
 * @date 2021-11-25
 */
@Controller
@RequestMapping("/system/todo")
public class FamilyMyTodoController extends BaseController
{
    private String prefix = "system/todo";

    @Autowired
    private IFamilyMyTodoService familyMyTodoService;

    @RequiresPermissions("system:todo:view")
    @GetMapping()
    public String todo()
    {
        return prefix + "/todo";
    }

    /**
     * 查询首页通知列表
     */
    @RequiresPermissions("system:todo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyMyTodo familyMyTodo)
    {
        startPage();
        List<FamilyMyTodo> list = familyMyTodoService.selectFamilyMyTodoList(familyMyTodo);
        return getDataTable(list);
    }

    @PostMapping("/listtodo")
    @ResponseBody
    public AjaxResult listtodo(FamilyMyTodo familyMyTodo)
    {
        List<FamilyMyTodo> list = familyMyTodoService.selectMyTodoList(familyMyTodo);
        return AjaxResult.success(list);
    }

    /**
     * 导出首页通知列表
     */
    @RequiresPermissions("system:todo:export")
    @Log(title = "首页通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyMyTodo familyMyTodo)
    {
        List<FamilyMyTodo> list = familyMyTodoService.selectFamilyMyTodoList(familyMyTodo);
        ExcelUtil<FamilyMyTodo> util = new ExcelUtil<FamilyMyTodo>(FamilyMyTodo.class);
        return util.exportExcel(list, "首页通知数据");
    }

    /**
     * 新增首页通知
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页通知
     */
    @RequiresPermissions("system:todo:add")
    @Log(title = "首页通知", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyMyTodo familyMyTodo)
    {
        return AjaxResult.success("success",familyMyTodoService.insertFamilyMyTodo(familyMyTodo));
    }

    /**
     * 修改首页通知
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyMyTodo familyMyTodo = familyMyTodoService.selectFamilyMyTodoById(id);
        mmap.put("familyMyTodo", familyMyTodo);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页通知
     */
    @Log(title = "首页通知", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyMyTodo familyMyTodo)
    {
        return toAjax(familyMyTodoService.updateFamilyMyTodo(familyMyTodo));
    }

    @PostMapping("/doedit")
    @ResponseBody
    public AjaxResult doEditSave(FamilyMyTodo familyMyTodo)
    {
        familyMyTodo.setDoTime(new Date());
        return toAjax(familyMyTodoService.updateFamilyMyTodo(familyMyTodo));
    }
    /**
     * 删除首页通知
     */
    @RequiresPermissions("system:todo:remove")
    @Log(title = "首页通知", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyMyTodoService.deleteFamilyMyTodoByIds(ids));
    }
}
