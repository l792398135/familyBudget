package com.ruoyi.web.controller.system;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
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
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.service.ISysAttachmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 附件Controller
 * 
 * @author ruoyi
 * @date 2021-09-14
 */
@Controller
@RequestMapping("/system/attachment")
public class SysAttachmentController extends BaseController
{
    private String prefix = "system/attachment";

    @Autowired
    private ISysAttachmentService sysAttachmentService;

    @RequiresPermissions("system:attachment:view")
    @GetMapping()
    public String attachment()
    {
        return prefix + "/attachment";
    }

    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(SysAttachment attachment)
    {
        return toAjax(sysAttachmentService.insertSysAttachment(attachment));
    }


    @PostMapping("/load")
    @ResponseBody
    public String load(SysAttachment attachment)
    {
        List<SysAttachment> alist = sysAttachmentService.selectSysAttachmentList(attachment);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        jsonObject.put("alist", alist);
        return jsonObject.toString();
    }
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(String ids)
    {
        try
        {
            return toAjax(sysAttachmentService.deleteSysAttachmentByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 查询附件列表
     */
    @RequiresPermissions("system:attachment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysAttachment sysAttachment)
    {
        startPage();
        List<SysAttachment> list = sysAttachmentService.selectSysAttachmentList(sysAttachment);
        return getDataTable(list);
    }

    /**
     * 导出附件列表
     */
    @RequiresPermissions("system:attachment:export")
    @Log(title = "附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysAttachment sysAttachment)
    {
        List<SysAttachment> list = sysAttachmentService.selectSysAttachmentList(sysAttachment);
        ExcelUtil<SysAttachment> util = new ExcelUtil<SysAttachment>(SysAttachment.class);
        return util.exportExcel(list, "附件数据");
    }

    /**
     * 新增附件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }


    /**
     * 新增保存附件
     */
    @RequiresPermissions("system:attachment:add")
    @Log(title = "附件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysAttachment sysAttachment)
    {
        return toAjax(sysAttachmentService.insertSysAttachment(sysAttachment));
    }

    /**
     * 修改附件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        SysAttachment sysAttachment = sysAttachmentService.selectSysAttachmentById(id);
        mmap.put("sysAttachment", sysAttachment);
        return prefix + "/edit";
    }

    /**
     * 修改保存附件
     */
    @RequiresPermissions("system:attachment:edit")
    @Log(title = "附件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysAttachment sysAttachment)
    {
        return toAjax(sysAttachmentService.updateSysAttachment(sysAttachment));
    }

    /**
     * 删除附件
     */
    @RequiresPermissions("system:attachment:remove")
    @Log(title = "附件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysAttachmentService.deleteSysAttachmentByIds(ids));
    }
}
