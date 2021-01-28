package com.miniprogram.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputObject {
    private String sucMsg;
    private String errMsg;

    private Map<String, Object> data;
    private Map<String, Object> data2;

    private List<Map<String, String>> datas;
    private List<Map<String, Object>> datas2;

    public String getSucMsg() {
        return sucMsg;
    }

    public void setSucMsg(String sucMsg) {
        this.sucMsg = sucMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData2() {
        return data2;
    }

    public void setData2(Map<String, Object> data2) {
        this.data2 = data2;
    }

    public List<Map<String, String>> getDatas() {
        return datas;
    }

    public void setDatas(List<Map<String, String>> datas) {
        this.datas = datas;
    }

    public List<Map<String, Object>> getDatas2() {
        return datas2;
    }

    public void setDatas2(List<Map<String, Object>> datas2) {
        this.datas2 = datas2;
    }
}
