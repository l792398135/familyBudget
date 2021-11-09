package com.ruoyi.fixedasset.controller;

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
import com.ruoyi.fixedasset.domain.FamilyAccount;
import com.ruoyi.fixedasset.service.IFamilyAccountService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 账号管理Controller
 * 
 * @author ruoyi
 * @date 2021-10-15
 */
@Controller
@RequestMapping("/search/account")
public class FamilyAccountController extends BaseController
{
    private String prefix = "search/account";

    @Autowired
    private IFamilyAccountService familyAccountService;

    @RequiresPermissions("search:account:view")
    @GetMapping()
    public String account()
    {
        return prefix + "/account";
    }

    /**
     * 查询账号管理列表
     */
    @RequiresPermissions("search:account:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyAccount familyAccount)
    {
        startPage();
        List<FamilyAccount> list = familyAccountService.selectFamilyAccountList(familyAccount);
        return getDataTable(list);
    }

    /**
     * 导出账号管理列表
     */
    @RequiresPermissions("search:account:export")
    @Log(title = "账号管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyAccount familyAccount)
    {
        List<FamilyAccount> list = familyAccountService.selectFamilyAccountList(familyAccount);
        ExcelUtil<FamilyAccount> util = new ExcelUtil<FamilyAccount>(FamilyAccount.class);
        return util.exportExcel(list, "账号管理数据");
    }

    /**
     * 新增账号管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存账号管理
     */
    @RequiresPermissions("search:account:add")
    @Log(title = "账号管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyAccount familyAccount)
    {
        return AjaxResult.success("success",familyAccountService.insertFamilyAccount(familyAccount));
    }

    /**
     * 修改账号管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyAccount familyAccount = familyAccountService.selectFamilyAccountById(id);
        mmap.put("familyAccount", familyAccount);
        return prefix + "/edit";
    }

    @GetMapping("/encrypt/{id}")
    public String encrypt(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyAccount familyAccount = familyAccountService.selectFamilyAccountById(id);
        mmap.put("familyAccount", familyAccount);
        return prefix + "/encrypt";
    }

    /**
     * 修改保存账号管理
     */
    @RequiresPermissions("search:account:edit")
    @Log(title = "账号管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyAccount familyAccount)
    {
        return toAjax(familyAccountService.updateFamilyAccount(familyAccount));
    }

    @PostMapping("/encryptSaltPassword")
    @ResponseBody
    public AjaxResult encryptSaltPassword(FamilyAccount familyAccount)
    {
        return AjaxResult.success(familyAccountService.encryptSaltPassword(familyAccount));
    }

    /**
     * 删除账号管理
     */
    @RequiresPermissions("search:account:remove")
    @Log(title = "账号管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyAccountService.deleteFamilyAccountByIds(ids));
    }
}
