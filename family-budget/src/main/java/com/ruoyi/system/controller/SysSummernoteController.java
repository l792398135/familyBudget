package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.SysSummernote;
import com.ruoyi.system.service.ISysSummernoteService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 富文本数据Controller
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
@Controller
@RequestMapping("/system/summernote")
public class SysSummernoteController extends BaseController
{
    private String prefix = "system/summernote";

    @Autowired
    private ISysSummernoteService sysSummernoteService;

    @GetMapping()
    public String summernote()
    {
        return prefix + "/summernote";
    }

    @GetMapping("/child")
    public String childSummernote()
    {
        return   "child/teach";
    }

    @GetMapping("/help")
    public String helpNote()
    {
        return   "note/help";
    }

    @GetMapping("/log")
    public String logNote()
    {
        return   "note/log";
    }

    @PostMapping("/note")
    @ResponseBody
    public AjaxResult querySummernote(SysSummernote sysSummernote)
    {
        SysSummernote note = sysSummernoteService.selectSysSummernote(sysSummernote);
        return AjaxResult.success(note);
    }

    /**
     * 查询富文本数据列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysSummernote sysSummernote)
    {
        startPage();
        List<SysSummernote> list = sysSummernoteService.selectSysSummernoteList(sysSummernote);
        return getDataTable(list);
    }

    /**
     * 导出富文本数据列表
     */
    @Log(title = "富文本数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysSummernote sysSummernote)
    {
        List<SysSummernote> list = sysSummernoteService.selectSysSummernoteList(sysSummernote);
        ExcelUtil<SysSummernote> util = new ExcelUtil<SysSummernote>(SysSummernote.class);
        return util.exportExcel(list, "富文本数据数据");
    }

    /**
     * 新增富文本数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存富文本数据
     */
    @Log(title = "富文本数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysSummernote sysSummernote)
    {
        return AjaxResult.success("success",sysSummernoteService.insertSysSummernote(sysSummernote));
    }

    /**
     * 修改富文本数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SysSummernote sysSummernote = sysSummernoteService.selectSysSummernoteById(id);
        mmap.put("sysSummernote", sysSummernote);
        return prefix + "/edit";
    }

    /**
     * 修改保存富文本数据
     */
    @Log(title = "富文本数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysSummernote sysSummernote)
    {
        return toAjax(sysSummernoteService.updateSysSummernote(sysSummernote));
    }

    /**
     * 删除富文本数据
     */
    @Log(title = "富文本数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysSummernoteService.deleteSysSummernoteByIds(ids));
    }
}
