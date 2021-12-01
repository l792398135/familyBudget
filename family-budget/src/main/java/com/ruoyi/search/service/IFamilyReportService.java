package com.ruoyi.search.service;

import com.ruoyi.search.vo.ChartVO;
import com.ruoyi.search.vo.ChildFundVO;
import com.ruoyi.search.vo.TopNVO;

import java.util.List;
import java.util.Map;

public interface IFamilyReportService {
    /**
     *localMonthPay 当月支出
     *preMonthIncome 上月收入
     *localMonthBudget 本月预算支出
     *localMonthBudgetIncome 本月预算收入
     *localMonthIncome 本月收入
     *checkFund 有效盘点的金额
     *fundNet 距离上次有效盘点后的加收入减支出
     *fixedAssets 固定资产当前值的估值,单位万
     * @return
     */
    Map<String,Object> getMonthData();

    List<TopNVO> getTopN(String type);

    List<Map<String, Object>> getMonthPayChart();

    List<Map<String, Object>> getMonthIncomeChart();

    /**
     * 查询支出
     * @param code
     * @return
     */
    List<ChartVO> getPay(String code);

    /**
     * 查询收入
     * @param code
     * @return
     */
    List<ChartVO> getIncome(String code);

    List<TopNVO> getPeopleMoney();

    /**
     * 预算支出
     * @param code
     * @return
     */
    List<ChartVO> getPayBudget(String code);

    /**
     * 预算收入
     * @param code
     * @return
     */
    List<ChartVO> getIncomeBudget(String code);

    List<ChildFundVO> babyAgentAmountList();
}
