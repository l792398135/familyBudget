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
import com.ruoyi.finance.domain.FamilyBill;
import com.ruoyi.finance.service.IFamilyBillService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 单据管理Controller
 * 
 * @author ruoyi
 * @date 2021-09-26
 */
@Controller
@RequestMapping("/search/bill")
public class FamilyBillController extends BaseController
{
    private String prefix = "search/bill";

    @Autowired
    private IFamilyBillService familyBillService;

    @RequiresPermissions("search:bill:view")
    @GetMapping()
    public String bill()
    {
        return prefix + "/bill";
    }

    /**
     * 查询单据管理列表
     */
    @RequiresPermissions("search:bill:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyBill familyBill)
    {
        startPage();
        List<FamilyBill> list = familyBillService.selectFamilyBillList(familyBill);
        return getDataTable(list);
    }

    /**
     * 导出单据管理列表
     */
    @RequiresPermissions("search:bill:export")
    @Log(title = "单据管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyBill familyBill)
    {
        List<FamilyBill> list = familyBillService.selectFamilyBillList(familyBill);
        ExcelUtil<FamilyBill> util = new ExcelUtil<FamilyBill>(FamilyBill.class);
        return util.exportExcel(list, "单据管理数据");
    }

    /**
     * 新增单据管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存单据管理
     */
    @RequiresPermissions("search:bill:add")
    @Log(title = "单据管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyBill familyBill)
    {
        return AjaxResult.success("success",familyBillService.insertFamilyBill(familyBill));
    }

    /**
     * 修改单据管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyBill familyBill = familyBillService.selectFamilyBillById(id);
        mmap.put("familyBill", familyBill);
        return prefix + "/edit";
    }

    /**
     * 修改保存单据管理
     */
    @RequiresPermissions("search:bill:edit")
    @Log(title = "单据管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyBill familyBill)
    {
        return toAjax(familyBillService.updateFamilyBill(familyBill));
    }

    /**
     * 删除单据管理
     */
    @RequiresPermissions("search:bill:remove")
    @Log(title = "单据管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyBillService.deleteFamilyBillByIds(ids));
    }
}
