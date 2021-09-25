package com.ruoyi.pay.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.pay.mapper.FamilyMonthBudgetMapper;
import com.ruoyi.pay.mapper.FamilyPayMapper;
import com.ruoyi.pay.mapper.FamilyReportMapper;
import com.ruoyi.pay.service.IFamilyReportService;
import com.ruoyi.pay.vo.TopNVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> result = new HashMap<>();
        result.put("localMonthPay",localMonthPay);
        result.put("preMonthIncome",preMonthIncome);
        result.put("localMonthBudget",localMonthBudget);
        result.put("localMonthIncome",localMonthIncome);
        result.put("checkFund",checkFund);
        BigDecimal divide = fixedAssets.divide(new BigDecimal(10000), 2, BigDecimal.ROUND_HALF_UP);
        result.put("fixedAssets",divide);
        return result;
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
}
