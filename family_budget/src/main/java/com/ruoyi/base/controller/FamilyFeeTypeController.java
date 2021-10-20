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
import com.ruoyi.base.domain.FamilyFeeType;
import com.ruoyi.base.service.IFamilyFeeTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 费用类型Controller
 * 
 * @author ruoyi
 * @date 2021-10-19
 */
@Controller
@RequestMapping("/base/feeType")
public class FamilyFeeTypeController extends BaseController
{
    private String prefix = "base/feeType";

    @Autowired
    private IFamilyFeeTypeService familyFeeTypeService;

    @RequiresPermissions("base:feeType:view")
    @GetMapping()
    public String feeType()
    {
        return prefix + "/feeType";
    }

    /**
     * 查询费用类型列表
     */
    @RequiresPermissions("base:feeType:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyFeeType familyFeeType)
    {
        startPage();
        List<FamilyFeeType> list = familyFeeTypeService.selectFamilyFeeTypeList(familyFeeType);
        return getDataTable(list);
    }

    @RequiresPermissions("base:feeType:export")
    @Log(title = "费用类型", businessType = BusinessType.EXPORT)
    @PostMapping("/refresh")
    @ResponseBody
    public AjaxResult export()
    {
        familyFeeTypeService.refresh();
        return AjaxResult.success();
    }

    /**
     * 新增费用类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存费用类型
     */
    @RequiresPermissions("base:feeType:add")
    @Log(title = "费用类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyFeeType familyFeeType)
    {
        return AjaxResult.success("success",familyFeeTypeService.insertFamilyFeeType(familyFeeType));
    }

    /**
     * 修改费用类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyFeeType familyFeeType = familyFeeTypeService.selectFamilyFeeTypeById(id);
        mmap.put("familyFeeType", familyFeeType);
        return prefix + "/edit";
    }

    /**
     * 修改保存费用类型
     */
    @RequiresPermissions("base:feeType:edit")
    @Log(title = "费用类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyFeeType familyFeeType)
    {
        return toAjax(familyFeeTypeService.updateFamilyFeeType(familyFeeType));
    }

    /**
     * 删除费用类型
     */
    @RequiresPermissions("base:feeType:remove")
    @Log(title = "费用类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyFeeTypeService.deleteFamilyFeeTypeByIds(ids));
    }
}
