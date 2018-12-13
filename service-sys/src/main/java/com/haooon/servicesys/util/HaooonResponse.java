package com.haooon.servicesys.util;

public class HaooonResponse {
    public String status = "uninitialized";
    public String body = "";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
