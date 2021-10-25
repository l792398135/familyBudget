package com.ruoyi.search.mapper;


import com.ruoyi.search.vo.TopNVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Select("select sum(budget_income) from family_month_budget where date_format(budget_date ,'%Y-%m') = date_format(curdate(),'%Y-%m')")
    BigDecimal getLoaclMonthBudgetIncome();

    @Select("select sum(buy_cost) from family_fixed_assets ")
    BigDecimal getFixedAssets();

    @Select("select sum(fund_amount ) from family_check_details fcd where check_code = " +
            "( " +
            "select max(check_code ) from family_fund_check ffc  where ffc.status =0  and start_time is not null " +
            ")")
    BigDecimal getCheckFund();

    List<TopNVO> topN1();

    List<TopNVO> topN2();

    List<TopNVO> topN3();

    List<TopNVO> topN4();

    List<TopNVO> topN5();

    List<TopNVO> topN6();



    @Select("select start_time from family_fund_check where status = '0' limit 1")
    Date getFundCheckStartTime();

    @Select("select sum(income_cost) from family_income where income_date>#{stat_time}")
    BigDecimal getFundCheckIncome(Date startTime);

    @Select("select sum(pay_cost) from family_pay where pay_date> #{statTime}")
    BigDecimal getFundCheckPay(Date startTime);

    @Select("select  date_format(pay_date ,'%Y-%m' ) date_field,sum(pay_cost) cost_field from family_pay fp group by  date_format(pay_date ,'%Y-%m' )  order by date_field ")
    List<Map<String, Object>> getMonthPayChart();

    @Select("select  date_format(income_date ,'%Y-%m' ) date_field,sum(income_cost ) cost_field  from family_income fi group by date_format(income_date ,'%Y-%m' ) order by date_field")
    List<Map<String, Object>> getMonthIncomeChart();

    @Select("select date_format(pay_date ,'%Y-%m') date_field,pay_menber menber,sum(pay_cost ) cost_field from family_pay  where pay_type_code =#{code} group by date_format(pay_date ,'%Y-%m'),pay_menber ")
    List<Map<String, Object>> getPay(@Value("code") String code);

    @Select("select date_format(income_date ,'%Y-%m') date_field,income_menber menber ,sum(income_cost ) cost_field from family_income  where income_type_code =#{code} group by date_format(income_date ,'%Y-%m'),income_menber ")
    List<Map<String, Object>> getIncome(@Value("code") String code);

    List<TopNVO> getCheckListByCheckCode(String checkCode);

    List<TopNVO> getPayListByCheckDate(Date startTime);

    List<TopNVO> getIncomeListByCheckDate(Date startTime);

}
