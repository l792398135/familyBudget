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
import com.ruoyi.payincome.domain.FamilyTransferAccount;
import com.ruoyi.payincome.service.IFamilyTransferAccountService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 转账Controller
 * 
 * @author ruoyi
 * @date 2021-09-22
 */
@Controller
@RequestMapping("/pay/transfer")
public class FamilyTransferAccountController extends BaseController
{
    private String prefix = "pay/transfer";

    @Autowired
    private IFamilyTransferAccountService familyTransferAccountService;

    @RequiresPermissions("pay:transfer:view")
    @GetMapping()
    public String transfer()
    {
        return prefix + "/transfer";
    }

    /**
     * 查询转账列表
     */
    @RequiresPermissions("pay:transfer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyTransferAccount familyTransferAccount)
    {
        startPage();
        List<FamilyTransferAccount> list = familyTransferAccountService.selectFamilyTransferAccountList(familyTransferAccount);
        return getDataTable(list);
    }

    /**
     * 导出转账列表
     */
    @RequiresPermissions("pay:transfer:export")
    @Log(title = "转账", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyTransferAccount familyTransferAccount)
    {
        List<FamilyTransferAccount> list = familyTransferAccountService.selectFamilyTransferAccountList(familyTransferAccount);
        ExcelUtil<FamilyTransferAccount> util = new ExcelUtil<FamilyTransferAccount>(FamilyTransferAccount.class);
        return util.exportExcel(list, "转账数据");
    }

    /**
     * 新增转账
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存转账
     */
    @RequiresPermissions("pay:transfer:add")
    @Log(title = "转账", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyTransferAccount familyTransferAccount)
    {
        return toAjax(familyTransferAccountService.insertFamilyTransferAccount(familyTransferAccount));
    }

    /**
     * 修改转账
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyTransferAccount familyTransferAccount = familyTransferAccountService.selectFamilyTransferAccountById(id);
        mmap.put("familyTransferAccount", familyTransferAccount);
        return prefix + "/edit";
    }

    /**
     * 修改保存转账
     */
    @RequiresPermissions("pay:transfer:edit")
    @Log(title = "转账", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyTransferAccount familyTransferAccount)
    {
        return toAjax(familyTransferAccountService.updateFamilyTransferAccount(familyTransferAccount));
    }

    /**
     * 删除转账
     */
    @RequiresPermissions("pay:transfer:remove")
    @Log(title = "转账", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyTransferAccountService.deleteFamilyTransferAccountByIds(ids));
    }
}
