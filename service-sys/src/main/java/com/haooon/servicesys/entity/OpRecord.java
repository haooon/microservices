package com.haooon.servicesys.entity;

import java.util.Date;

public class OpRecord {
    private Integer userId;

    private String opClass;

    private Date opTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpClass() {
        return opClass;
    }

    public void setOpClass(String opClass) {
        this.opClass = opClass == null ? null : opClass.trim();
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }
}