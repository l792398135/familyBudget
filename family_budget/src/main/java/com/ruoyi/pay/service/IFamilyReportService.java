package com.ruoyi.pay.service;

import com.ruoyi.pay.vo.TopNVO;

import java.util.List;
import java.util.Map;

public interface IFamilyReportService {

    Map<String,Object> getMonthData();

    List<TopNVO> getTopN(String type);

}
