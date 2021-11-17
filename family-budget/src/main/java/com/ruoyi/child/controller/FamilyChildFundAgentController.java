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
import com.ruoyi.child.domain.FamilyChildFundAgent;
import com.ruoyi.child.service.IFamilyChildFundAgentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资金代管Controller
 * 
 * @author ruoyi
 * @date 2021-11-16
 */
@Controller
@RequestMapping("/child/agent")
public class FamilyChildFundAgentController extends BaseController
{
    private String prefix = "child/agent";

    @Autowired
    private IFamilyChildFundAgentService familyChildFundAgentService;

    @RequiresPermissions("child:agent:view")
    @GetMapping()
    public String agent()
    {
        return prefix + "/agent";
    }

    /**
     * 查询资金代管列表
     */
    @RequiresPermissions("child:agent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FamilyChildFundAgent familyChildFundAgent)
    {
        startPage();
        List<FamilyChildFundAgent> list = familyChildFundAgentService.selectFamilyChildFundAgentList(familyChildFundAgent);
        return getDataTable(list);
    }

    /**
     * 导出资金代管列表
     */
    @RequiresPermissions("child:agent:export")
    @Log(title = "资金代管", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FamilyChildFundAgent familyChildFundAgent)
    {
        List<FamilyChildFundAgent> list = familyChildFundAgentService.selectFamilyChildFundAgentList(familyChildFundAgent);
        ExcelUtil<FamilyChildFundAgent> util = new ExcelUtil<FamilyChildFundAgent>(FamilyChildFundAgent.class);
        return util.exportExcel(list, "资金代管数据");
    }

    /**
     * 新增资金代管
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资金代管
     */
    @RequiresPermissions("child:agent:add")
    @Log(title = "资金代管", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FamilyChildFundAgent familyChildFundAgent)
    {
        return AjaxResult.success("success",familyChildFundAgentService.insertFamilyChildFundAgent(familyChildFundAgent));
    }

    /**
     * 修改资金代管
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FamilyChildFundAgent familyChildFundAgent = familyChildFundAgentService.selectFamilyChildFundAgentById(id);
        mmap.put("familyChildFundAgent", familyChildFundAgent);
        return prefix + "/edit";
    }

    /**
     * 修改保存资金代管
     */
    @RequiresPermissions("child:agent:edit")
    @Log(title = "资金代管", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FamilyChildFundAgent familyChildFundAgent)
    {
        return toAjax(familyChildFundAgentService.updateFamilyChildFundAgent(familyChildFundAgent));
    }

    /**
     * 删除资金代管
     */
    @RequiresPermissions("child:agent:remove")
    @Log(title = "资金代管", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(familyChildFundAgentService.deleteFamilyChildFundAgentByIds(ids));
    }
}
