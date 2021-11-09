package com.ruoyi.finance.controller;

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
import com.ruoyi.finance.domain.FamilyProjectManage;
import com.ruoyi.finance.service.IFamilyProjectManageService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目管理Controller
 * 
 * @author ruoyi
 * @date 2021-09-27
 */
@Controller
@RequestMapping("/search/projectMange")
public class FamilyProjectManageController extends BaseController
{
    private String prefix = "search/projectMange";

    @Autowired
    private IFamilyProjectManageService familyProjectManageService;

    @RequiresPermissions("search:projectMange:view")
    @GetMapping()
    public String projectMange()
    {
        return prefix + "/projectMange";
    }

    /**
     * 查询项目管理列表
     */
    @RequiresPermissions("search:projectMange:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyProjectManage familyProjectManage)
    {
        startPage();
        List<FamilyProjectManage> list = familyProjectManageService.selectFamilyProjectManageList(familyProjectManage);
        return getDataTable(list);
    }

    /**
     * 导出项目管理列表
     */
    @RequiresPermissions("search:projectMange:export")
    @Log(title = "项目管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyProjectManage familyProjectManage)
    {
        List<FamilyProjectManage> list = familyProjectManageService.selectFamilyProjectManageList(familyProjectManage);
        ExcelUtil<FamilyProjectManage> util = new ExcelUtil<FamilyProjectManage>(FamilyProjectManage.class);
        return util.exportExcel(list, "项目管理数据");
    }

    /**
     * 新增项目管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目管理
     */
    @RequiresPermissions("search:projectMange:add")
    @Log(title = "项目管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyProjectManage familyProjectManage)
    {
        return AjaxResult.success(familyProjectManageService.insertFamilyProjectManage(familyProjectManage));
    }

    /**
     * 修改项目管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyProjectManage familyProjectManage = familyProjectManageService.selectFamilyProjectManageById(id);
        mmap.put("familyProjectManage", familyProjectManage);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目管理
     */
    @RequiresPermissions("search:projectMange:edit")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyProjectManage familyProjectManage)
    {
        return toAjax(familyProjectManageService.updateFamilyProjectManage(familyProjectManage));
    }

    /**
     * 删除项目管理
     */
    @RequiresPermissions("search:projectMange:remove")
    @Log(title = "项目管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyProjectManageService.deleteFamilyProjectManageByIds(ids));
    }
}
