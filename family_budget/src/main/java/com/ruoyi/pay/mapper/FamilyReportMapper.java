package com.ruoyi.pay.mapper;


import com.ruoyi.pay.vo.TopNVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface FamilyReportMapper {
    @Select("select sum(pay_cost) from family_pay fp where date_format(pay_date ,'%Y-%m') = date_format(curdate() ,'%Y-%m') ")
    BigDecimal getLocalMonthPay();

    @Select("select sum(income_cost) from family_income fi where date_format(income_date ,'%Y-%m') = date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m') ")
    BigDecimal getPreMonthIncome();

    @Select("select sum(income_cost) from family_income fi where date_format(income_date ,'%Y-%m') = date_format(curdate(),'%Y-%m') ")
    BigDecimal getLocalMonthIncome();

    @Select("select sum(budget_cost) from family_month_budget where date_format(budget_date ,'%Y-%m') = date_format(curdate(),'%Y-%m')")
    BigDecimal getLoaclMonthBudget();

    @Select("select sum(buy_cost) from family_fixed_assets ")
    BigDecimal getFixedAssets();

    List<TopNVO> topN1();

    List<TopNVO> topN2();

    List<TopNVO> topN3();

    List<TopNVO> topN4();

    List<TopNVO> topN5();

    List<TopNVO> topN6();


}
