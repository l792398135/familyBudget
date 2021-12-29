package com.ruoyi.payincome.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.payincome.domain.FamilyPay;
import com.ruoyi.payincome.service.IFamilyRefundService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 费用支出Controller
 * 
 * @author ruoyi
 * @date 2021-09-10
 */
@Controller
@RequestMapping("/refund")
public class FamilyRefundController extends BaseController
{
    private String prefix = "pay/refund";

    @Autowired
    private IFamilyRefundService familyRefundService;

    @GetMapping()
    public String pay()
    {
        return prefix + "/refund";
    }

    /**
     * 查询费用支出列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyPay familyPay)
    {
        startPage();
        List<FamilyPay> list = familyRefundService.selectFamilyPayList(familyPay);
        return getDataTable(list);
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
    @Log(title = "费用支出", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyPay familyPay)
    {
        return toAjax(familyRefundService.insertFamilyPay(familyPay));
    }

    /**
     * 修改费用支出
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyPay familyPay = familyRefundService.selectFamilyPayById(id);
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
        FamilyPay familyPay1 = familyRefundService.selectFamilyPayById(familyPay.getId());
        Long businessId = familyPay1.getBusinessId();
        if (!ObjectUtils.isEmpty(businessId)){
            throw new BusinessException("其他操作生成的记录，不允许此处修改！");
        }
        return toAjax(familyRefundService.updateFamilyPay(familyPay));
    }

    /**
     * 删除费用支出
     */
    @Log(title = "费用支出", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyRefundService.deleteFamilyPayByIds(ids));
    }
}
