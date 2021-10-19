package com.ruoyi.search.service.impl;

import com.ruoyi.search.mapper.FamilyReportMapper;
import com.ruoyi.search.service.IFamilyReportService;
import com.ruoyi.search.vo.ChartVO;
import com.ruoyi.search.vo.TopNVO;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FamilyReportServiceImpl implements IFamilyReportService {
    @Autowired
    private FamilyReportMapper familyReportMapper;

    @Override
    public Map<String, Object> getMonthData() {
        BigDecimal localMonthPay = familyReportMapper.getLocalMonthPay();
        BigDecimal preMonthIncome = familyReportMapper.getPreMonthIncome();
        BigDecimal localMonthBudget = familyReportMapper.getLoaclMonthBudget();
        BigDecimal localMonthIncome = familyReportMapper.getLocalMonthIncome();
        BigDecimal fixedAssets = familyReportMapper.getFixedAssets();
        BigDecimal checkFund = familyReportMapper.getCheckFund();
        BigDecimal fundNet = getfundNet();
        Map<String, Object> result = new HashMap<>();
        result.put("localMonthPay",localMonthPay);
        result.put("preMonthIncome",preMonthIncome);
        result.put("localMonthBudget",localMonthBudget);
        result.put("localMonthIncome",localMonthIncome);
        result.put("checkFund",checkFund);
        result.put("fundNet",fundNet);
        BigDecimal divide = fixedAssets.divide(new BigDecimal(10000), 2, BigDecimal.ROUND_HALF_UP);
        result.put("fixedAssets",divide);
        return result;
    }

    private BigDecimal getfundNet() {
        Date startTime = familyReportMapper.getFundCheckStartTime();
        BigDecimal checkFund = familyReportMapper.getCheckFund();
        if (startTime!=null) {
            BigDecimal income = familyReportMapper.getFundCheckIncome(startTime);
            BigDecimal pay = familyReportMapper.getFundCheckPay(startTime);
            return checkFund.add(income).subtract(pay);
        }else{
            return null;
        }
    }

    @Override
    public List<TopNVO> getTopN(String type) {
        List<TopNVO> result = new ArrayList<>();
        if (type.equals("localMonthIncome")){
            result =familyReportMapper.topN1();
        }else if (type.equals("preMonthIncome")){
            result =familyReportMapper.topN2();
        }else if (type.equals("localMonthPay")){
            result =familyReportMapper.topN3();
        }else if (type.equals("localMonthPayCode")){
            result =familyReportMapper.topN4();
        }else if (type.equals("localMonthOperatorCount")){
            result =familyReportMapper.topN5();
        }else if (type.equals("localMonthBookkeeperCount")){
            result =familyReportMapper.topN6();
        }else {
            throw new RuntimeException("没有这个类型");
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> getMonthPayChart() {
        return familyReportMapper.getMonthPayChart();
    }

    @Override
    public List<Map<String, Object>> getMonthIncomeChart() {
        return familyReportMapper.getMonthIncomeChart();
    }

    @Override
    public List<ChartVO> getPay(String code) {
        List<Map<String, Object>> res = familyReportMapper.getPay(code);
        List<ChartVO> result = new ArrayList<>();
        List<String> date_fields = res.stream().map(r -> r.get("date_field").toString()).distinct().sorted().collect(Collectors.toList());
        Map<String, List<Map<String, Object>>> pay_menber = res.stream().collect(Collectors.groupingBy(map -> map.get("pay_menber").toString()));
        for (Map.Entry<String, List<Map<String, Object>>> stringListEntry : pay_menber.entrySet()) {
            String key = stringListEntry.getKey();
            List<Map<String, Object>> value = stringListEntry.getValue();
            List<Map<String, Object>> objects = new ArrayList<>();
            for (String date_field : date_fields) {
                for (Map<String, Object> stringObjectMap : value) {
                    Object date_field1 = stringObjectMap.get("date_field");
                    if (ObjectUtils.isEmpty(date_field1)){
                        continue;
                    }else {
                        String s = date_field1.toString();
                        if (s.equals(date_field)){
                            Map<String, Object> tmp = new HashMap<>();
                            tmp.put("dataName",date_field);
                            tmp.put("dataNum",stringObjectMap.get("cost_field").toString());
                            objects.add(tmp);
                        }
                    }
                }
            }
            ChartVO chartVO = new ChartVO();
            chartVO.setChartId("echarts-pay");
            chartVO.setName(key);
            chartVO.setData(objects);
            result.add(chartVO);
        }
        return result;
    }

    @Override
    public List<ChartVO> getIncome(String code) {
        List<Map<String, Object>> res = familyReportMapper.getIncome(code);
        List<ChartVO> result = new ArrayList<>();
        List<String> date_fields = res.stream().map(r -> r.get("date_field").toString()).distinct().sorted().collect(Collectors.toList());
        Map<String, List<Map<String, Object>>> pay_menber = res.stream().collect(Collectors.groupingBy(map -> map.get("pay_menber").toString()));
        for (Map.Entry<String, List<Map<String, Object>>> stringListEntry : pay_menber.entrySet()) {
            String key = stringListEntry.getKey();
            List<Map<String, Object>> value = stringListEntry.getValue();
            List<Map<String, Object>> objects = new ArrayList<>();
            for (String date_field : date_fields) {
                for (Map<String, Object> stringObjectMap : value) {
                    Object date_field1 = stringObjectMap.get("date_field");
                    if (ObjectUtils.isEmpty(date_field1)){
                        continue;
                    }else {
                        String s = date_field1.toString();
                        if (s.equals(date_field)){
                            Map<String, Object> tmp = new HashMap<>();
                            tmp.put("dataName",date_field);
                            tmp.put("dataNum",stringObjectMap.get("cost_field").toString());
                            objects.add(tmp);
                        }
                    }
                }
            }
            ChartVO chartVO = new ChartVO();
            chartVO.setChartId("echarts-income");
            chartVO.setName(key);
            chartVO.setData(objects);
            result.add(chartVO);
        }
        return result;
    }
}
