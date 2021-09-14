package com.ruoyi.pay.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.pay.service.IFamilyPayService;
import com.ruoyi.pay.service.IFamilyReportService;
import com.ruoyi.pay.vo.TopNVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api("报表")
@Controller
@RequestMapping("/report")
public class FamilyReportController extends BaseController {
    @Autowired
    private IFamilyReportService familyReportService;

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
}
