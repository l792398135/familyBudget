package com.ruoyi.search.service;

import com.ruoyi.search.vo.ChartVO;
import com.ruoyi.search.vo.TopNVO;

import java.util.List;
import java.util.Map;

public interface IFamilyReportService {

    Map<String,Object> getMonthData();

    List<TopNVO> getTopN(String type);

    List<Map<String, Object>> getMonthPayChart();

    List<Map<String, Object>> getMonthIncomeChart();

    List<ChartVO> getPay(String code);

    List<ChartVO> getIncome(String code);

    List<TopNVO> getPeopleMoney();
}
