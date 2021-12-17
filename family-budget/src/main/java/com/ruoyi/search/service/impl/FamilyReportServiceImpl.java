package com.ruoyi.search.service.impl;

import com.ruoyi.fixedasset.domain.FamilyFundCheck;
import com.ruoyi.fixedasset.mapper.FamilyFundCheckMapper;
import com.ruoyi.payincome.domain.FamilyTransferAccount;
import com.ruoyi.payincome.mapper.*;
import com.ruoyi.search.mapper.FamilyReportMapper;
import com.ruoyi.search.service.IFamilyReportService;
import com.ruoyi.search.vo.ChartVO;
import com.ruoyi.search.vo.ChildFundVO;
import com.ruoyi.search.vo.TopNVO;
import org.apache.commons.collections.CollectionUtils;
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
    @Autowired
    private FamilyFundCheckMapper fundCheckMapper;
    @Autowired
    private FamilyTransferAccountMapper transferAccountMapper;
    @Override
    public List<TopNVO> getPeopleMoney() {
        //查询有效的盘点
        FamilyFundCheck familyFundCheckParam = new FamilyFundCheck();
        familyFundCheckParam.setStatus("0");
        List<FamilyFundCheck> familyFundChecks = fundCheckMapper.selectFamilyFundCheckList(familyFundCheckParam);
        if(CollectionUtils.isEmpty(familyFundChecks)){
            return null;
        }
        FamilyFundCheck familyFundCheck = familyFundChecks.get(0);
        String checkCode = familyFundCheck.getCheckCode();
        Date startTime = familyFundCheck.getStartTime();
        //根据盘点编码，查询盘点人员金额list
        List<TopNVO> checkList = familyReportMapper.getCheckListByCheckCode(checkCode);
        //根据盘点时间，查询收入支出的金额 人员金额list
        List<TopNVO> payList = familyReportMapper.getPayListByCheckDate(startTime);
        List<TopNVO> incomeList = familyReportMapper.getIncomeListByCheckDate(startTime);
        //根据盘点时间，查出内部转账的金额list
        List<FamilyTransferAccount> transferAccounts = transferAccountMapper.getTramsferListByCheckDate(startTime);
        //组装
        List<TopNVO> collect = checkList.stream().map(r -> {
            String code = r.getCode();
            BigDecimal num = new BigDecimal(r.getNum());
            for (TopNVO topNVO : payList) {
                if (topNVO.getCode().equals(code)) {
                    num = num.subtract(new BigDecimal(topNVO.getNum()));
                }
            }
            for (TopNVO topNVO : incomeList) {
                if (topNVO.getCode().equals(code)) {
                    num = num.add(new BigDecimal(topNVO.getNum()));
                }
            }
            for (FamilyTransferAccount transferAccount : transferAccounts) {
                if (transferAccount.getTransfer().equals(r.getCode())){
                    num = num.subtract(transferAccount.getTransferAccount());
                }
            }
            for (FamilyTransferAccount transferAccount : transferAccounts) {
                if (transferAccount.getAccepter().equals(r.getCode())){
                    num = num.add(transferAccount.getTransferAccount());
                }
            }
            r.setNum(num.toString());
            r.setChartId("echarts-month-people");
            return r;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<ChartVO> getPayBudget(String code) {
        //查出code 对应的预算数据
        List<Map<String, Object>> budgetList = familyReportMapper.getBudget(code);
        //查出code 对应的实际数据
        List<Map<String, Object>> realList = familyReportMapper.getPayReal(code);
        budgetList.addAll(realList);
        //组装数据
        return getChartVOS(budgetList, "echarts-budget");
    }

    @Override
    public List<ChartVO> getIncomeBudget(String code) {
        //查出code 对应的预算数据
        List<Map<String, Object>> budgetList = familyReportMapper.getBudget(code);
        //查出code 对应的实际数据
        List<Map<String, Object>> realList = familyReportMapper.getIncomeReal(code);
        budgetList.addAll(realList);
        //组装数据
        return getChartVOS(budgetList, "echarts-budget");
    }

    @Override
    public List<ChildFundVO> babyAgentAmountList() {
        return familyReportMapper.babyAgentAmountList();
    }

    @Override
    public List<ChartVO> getIncomeAndPay() {
        List<Map<String, Object>> monthIncomeChart = familyReportMapper.getMonthIncomeChart();
        List<Map<String, Object>> monthPayChart = familyReportMapper.getMonthPayChart();
        monthIncomeChart.addAll(monthPayChart);
        return getChartVOS(monthIncomeChart, "echarts-incomepay");
    }

    @Override
    public List<ChartVO> localMoneyData() {
        //收入
        List<TopNVO> topNVOS = familyReportMapper.topN1();
        //支出
        List<TopNVO> topNVOS1 = familyReportMapper.topN3();

        List<ChartVO> results =new ArrayList<>();

        List<TopNVO> list = new ArrayList<>();
        list.addAll(topNVOS);
        list.addAll(topNVOS1);
        Set<String> nameSet = list.stream().map(r -> {
            return r.getName();
        }).collect(Collectors.toSet());

        for (String s : nameSet) {
            List<TopNVO> sIncome = topNVOS.stream().filter(r -> s.equals(r.getName())).collect(Collectors.toList());
            List<TopNVO> sPay = topNVOS1.stream().filter(r -> s.equals(r.getName())).collect(Collectors.toList());
            BigDecimal income =new BigDecimal(0);
            BigDecimal pay =new BigDecimal(0);
            if (sIncome.size()>0){
                income = new BigDecimal(sIncome.get(0).getNum());
            }
            if (sPay.size()>0){
                pay= new BigDecimal(sPay.get(0).getNum());
            }
            ChartVO chartVO = new ChartVO();
            chartVO.setName(s);
            Map<String, BigDecimal> dataMap = new HashMap<>();
            dataMap.put("benifit",income.subtract(pay));
            dataMap.put("pay",pay.negate() );
            dataMap.put("income",income);
            chartVO.setData(dataMap);
            results.add(chartVO);
        }
        return results;
    }

    @Override
    public Map<String, Object> getMonthData() {
        BigDecimal localMonthPay = familyReportMapper.getLocalMonthPay();
        BigDecimal preMonthIncome = familyReportMapper.getPreMonthIncome();
        BigDecimal localMonthBudget = familyReportMapper.getLoaclMonthBudget();
        BigDecimal localMonthBudgetIncome = familyReportMapper.getLoaclMonthBudgetIncome();
        BigDecimal localMonthIncome = familyReportMapper.getLocalMonthIncome();
        BigDecimal fixedAssets = familyReportMapper.getFixedAssets();
        BigDecimal checkFund = familyReportMapper.getCheckFund();
        BigDecimal fundNet = getfundNet();
        Map<String, Object> result = new HashMap<>();
        result.put("localMonthPay",localMonthPay);
        result.put("preMonthIncome",preMonthIncome);
        result.put("localMonthBudget",localMonthBudget);
        result.put("localMonthBudgetIncome",localMonthBudgetIncome);
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
        List<ChartVO> result = getChartVOS(res, "echarts-pay");
        return result;
    }

    private List<ChartVO> getChartVOS(List<Map<String, Object>> res, String s2) {
        List<ChartVO> result = new ArrayList<>();
        List<String> date_fields = res.stream().map(r -> r.get("date_field").toString()).distinct().sorted().collect(Collectors.toList());
        Map<String, List<Map<String, Object>>> pay_menber = res.stream().collect(Collectors.groupingBy(map -> map.get("menber").toString()));
        for (Map.Entry<String, List<Map<String, Object>>> stringListEntry : pay_menber.entrySet()) {
            String key = stringListEntry.getKey();
            List<Map<String, Object>> value = stringListEntry.getValue();
            List<Map<String, Object>> objects = new ArrayList<>();
            for (String date_field : date_fields) {
                List<Map<String, Object>> dataName = value.stream().filter(r -> r.get("date_field").equals(date_field)).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(dataName)){
                    Map<String, Object> tmp = new HashMap<>();
                    Map<String, Object> data = dataName.get(0);
                    tmp.put("dataName", date_field);
                    tmp.put("dataNum", data.get("cost_field").toString());
                    objects.add(tmp);
                }else{
                    Map<String, Object> tmp = new HashMap<>();
                    tmp.put("dataName", date_field);
                    tmp.put("dataNum", "0");
                    objects.add(tmp);
                }
            }
            ChartVO chartVO = new ChartVO();
            chartVO.setChartId(s2);
            chartVO.setName(key);
            chartVO.setData(objects);
            result.add(chartVO);
        }
        return result;
    }


    @Override
    public List<ChartVO> getIncome(String code) {
        List<Map<String, Object>> res = familyReportMapper.getIncome(code);
        List<ChartVO> result = getChartVOS(res, "echarts-income");
        return result;
    }
}
