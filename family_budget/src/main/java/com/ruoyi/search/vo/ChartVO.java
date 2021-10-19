package com.ruoyi.search.vo;

import java.io.Serializable;

public class ChartVO implements Serializable {
    String chartId;
    String name;
    //dataName dataNum
    Object data;

    public String getChartId() {
        return chartId;
    }

    public void setChartId(String chartId) {
        this.chartId = chartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
