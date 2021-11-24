package com.ruoyi.search.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.search.service.IFamilyReportService;
import com.ruoyi.search.vo.ChartVO;
import com.ruoyi.search.vo.TopNVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Api("报表")
@Controller
@RequestMapping("/report")
public class FamilyReportController extends BaseController {

    private String prefix = "search/report";

    @Autowired
    private IFamilyReportService familyReportService;

    @RequiresPermissions("report:report:view")
    @GetMapping("/report")
    public String report()
    {
        return prefix + "/monthReport";
    }

    @RequiresPermissions("report:search:view")
    @GetMapping("/search")
    public String searchReport()
    {
        return prefix + "/searchReport";
    }

    @GetMapping("/base")
    public String baseReport()
    {
        return prefix + "/baseReport";
    }

    @GetMapping("/getPayBudget/{code}")
    @ResponseBody
    public AjaxResult getPayBudget(@PathVariable("code") String code)
    {
        List<ChartVO> monthData = familyReportService.getPayBudget(code);
        return AjaxResult.success(monthData);
    }

    @GetMapping("/getIncomeBudget/{code}")
    @ResponseBody
    public AjaxResult getIncomeBudget(@PathVariable("code") String code)
    {
        List<ChartVO> monthData = familyReportService.getIncomeBudget(code);
        return AjaxResult.success(monthData);
    }

    @ApiOperation("现金排行")
    @GetMapping("/getPeopleMoney")
    @ResponseBody
    public AjaxResult getPeopleMoney()
    {
        List<TopNVO> peopleMoney = familyReportService.getPeopleMoney();
        return AjaxResult.success(peopleMoney);
    }

    @ApiOperation("查询收入明细")
    @GetMapping("/getIncome/{code}")
    @ResponseBody
    public AjaxResult getIncome(@PathVariable("code") String code)
    {
        List<ChartVO> monthData = familyReportService.getIncome(code);
        return AjaxResult.success(monthData);
    }

    @GetMapping("/getPay/{code}")
    @ResponseBody
    public AjaxResult getPay(@PathVariable("code") String code)
    {
        List<ChartVO> monthData = familyReportService.getPay(code);
        return AjaxResult.success(monthData);
    }


    @ApiOperation("获取月费用")
    @GetMapping("/getMonthData")
    @ResponseBody
    public AjaxResult getMonthData()
    {
        Map<String, Object> monthData = familyReportService.getMonthData();
        return AjaxResult.success(monthData);
    }

    @ApiOperation("获取排行")
    @GetMapping("/getTopN/{type}")
    @ResponseBody
    public AjaxResult getTopN(@PathVariable("type") String type){
        List<TopNVO> topN = familyReportService.getTopN(type);
        return AjaxResult.success(topN);
    }

    @ApiOperation("月度支出条形图")
    @GetMapping("/getMonthPayChart")
    @ResponseBody
    public AjaxResult getMonthPayChart()
    {
        List<Map<String, Object>> monthData = familyReportService.getMonthPayChart();
        return AjaxResult.success(monthData);
    }

    @ApiOperation("月度支出条形图")
    @GetMapping("/getMonthIncomeChart")
    @ResponseBody
    public AjaxResult getMonthIncomeChart()
    {
        List<Map<String, Object>> monthData = familyReportService.getMonthIncomeChart();
        return AjaxResult.success(monthData);
    }

}
