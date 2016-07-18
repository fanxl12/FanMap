package com.fanxl.fanmap.bean;

/**
 * 响应实体基类
 * Created by guilin on 16/1/6.
 */
public class BaseRo {

    private int RCode;
    private String RMessage;
    private int Total;

    public int getRCode() {
        return RCode;
    }

    public void setRCode(int RCode) {
        this.RCode = RCode;
    }

    public String getRMessage() {
        return RMessage;
    }

    public void setRMessage(String RMessage) {
        this.RMessage = RMessage;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
