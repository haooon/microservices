package com.haooon.serviceuser.service.impl;

import com.haooon.serviceuser.service.FSys;
import com.haooon.serviceuser.util.HaooonResponse;
import org.springframework.stereotype.Component;


@Component
public class HytrisSys implements FSys {
    @Override
    public HaooonResponse mail(Object param) {
        HaooonResponse response = new HaooonResponse();
        response.status = "error";
        response.body = "邮件系统繁忙";
        response.code = "SERVICEBUSY";
        return response;
    }
}