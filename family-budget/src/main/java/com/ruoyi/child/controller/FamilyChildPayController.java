package com.ruoyi.child.controller;

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
import com.ruoyi.child.domain.FamilyChildPay;
import com.ruoyi.child.service.IFamilyChildPayService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宝贝支出Controller
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
@Controller
@RequestMapping("/child/pay")
public class FamilyChildPayController extends BaseController
{
    private String prefix = "child/pay";

    @Autowired
    private IFamilyChildPayService familyChildPayService;

    @RequiresPermissions("child:pay:view")
    @GetMapping()
    public String pay()
    {
        return prefix + "/pay";
    }

    /**
     * 查询宝贝支出列表
     */
    @RequiresPermissions("child:pay:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyChildPay familyChildPay)
    {
        startPage();
        List<FamilyChildPay> list = familyChildPayService.selectFamilyChildPayList(familyChildPay);
        return getDataTable(list);
    }

    /**
     * 导出宝贝支出列表
     */
    @RequiresPermissions("child:pay:export")
    @Log(title = "宝贝支出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyChildPay familyChildPay)
    {
        List<FamilyChildPay> list = familyChildPayService.selectFamilyChildPayList(familyChildPay);
        ExcelUtil<FamilyChildPay> util = new ExcelUtil<FamilyChildPay>(FamilyChildPay.class);
        return util.exportExcel(list, "宝贝支出数据");
    }

    /**
     * 新增宝贝支出
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存宝贝支出
     */
    @RequiresPermissions("child:pay:add")
    @Log(title = "宝贝支出", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyChildPay familyChildPay)
    {
        return AjaxResult.success("success",familyChildPayService.insertFamilyChildPay(familyChildPay));
    }

    /**
     * 修改宝贝支出
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyChildPay familyChildPay = familyChildPayService.selectFamilyChildPayById(id);
        mmap.put("familyChildPay", familyChildPay);
        return prefix + "/edit";
    }

    /**
     * 修改保存宝贝支出
     */
    @RequiresPermissions("child:pay:edit")
    @Log(title = "宝贝支出", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyChildPay familyChildPay)
    {
        return toAjax(familyChildPayService.updateFamilyChildPay(familyChildPay));
    }

    /**
     * 删除宝贝支出
     */
    @RequiresPermissions("child:pay:remove")
    @Log(title = "宝贝支出", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyChildPayService.deleteFamilyChildPayByIds(ids));
    }
}
