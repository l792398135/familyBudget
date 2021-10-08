package com.ruoyi.search.service.impl;

import com.ruoyi.search.mapper.FamilyReportMapper;
import com.ruoyi.search.service.IFamilyReportService;
import com.ruoyi.search.vo.TopNVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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
}
