package com.haooon.servicefeign.feignstuff.hystric;

import com.haooon.servicefeign.feignstuff.FServiceSys;
import com.haooon.servicefeign.util.HaooonResponse;
import org.springframework.stereotype.Component;


@Component
public class FServiceSysHystric implements FServiceSys {
    @Override
    public HaooonResponse mail(Object param) {
        HaooonResponse response = new HaooonResponse();
        response.status = "error";
        response.body = "sorry service is busy now";
        return response;
    }
}

