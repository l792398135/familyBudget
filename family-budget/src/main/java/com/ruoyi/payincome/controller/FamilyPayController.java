package com.ruoyi.payincome.controller;

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
import com.ruoyi.payincome.domain.FamilyPay;
import com.ruoyi.payincome.service.IFamilyPayService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 费用支出Controller
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
@Controller
@RequestMapping("/pay/pay")
public class FamilyPayController extends BaseController
{
    private String prefix = "pay/pay";

    @Autowired
    private IFamilyPayService familyPayService;

    @RequiresPermissions("pay:pay:view")
    @GetMapping()
    public String pay()
    {
        return prefix + "/pay";
    }

    /**
     * 查询费用支出列表
     */
    @RequiresPermissions("pay:pay:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyPay familyPay)
    {
        startPage();
        List<FamilyPay> list = familyPayService.selectFamilyPayList(familyPay);
        return getDataTable(list);
    }

    /**
     * 导出费用支出列表
     */
    @RequiresPermissions("pay:pay:export")
    @Log(title = "费用支出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyPay familyPay)
    {
        List<FamilyPay> list = familyPayService.selectFamilyPayList(familyPay);
        ExcelUtil<FamilyPay> util = new ExcelUtil<FamilyPay>(FamilyPay.class);
        return util.exportExcel(list, "费用支出数据");
    }

    /**
     * 新增费用支出
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存费用支出
     */
    @RequiresPermissions("pay:pay:add")
    @Log(title = "费用支出", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyPay familyPay)
    {
        return toAjax(familyPayService.insertFamilyPay(familyPay));
    }

    /**
     * 修改费用支出
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyPay familyPay = familyPayService.selectFamilyPayById(id);
        mmap.put("familyPay", familyPay);
        return prefix + "/edit";
    }

    /**
     * 修改保存费用支出
     */
    @RequiresPermissions("pay:pay:edit")
    @Log(title = "费用支出", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyPay familyPay)
    {
        return toAjax(familyPayService.updateFamilyPay(familyPay));
    }

    /**
     * 删除费用支出
     */
    @RequiresPermissions("pay:pay:remove")
    @Log(title = "费用支出", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyPayService.deleteFamilyPayByIds(ids));
    }
}
