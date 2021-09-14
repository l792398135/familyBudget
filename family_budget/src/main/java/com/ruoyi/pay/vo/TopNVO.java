package com.ruoyi.pay.vo;

import java.io.Serializable;

public class TopNVO implements Serializable {

    private String name;

    private String code;

    private String num;

    public TopNVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
