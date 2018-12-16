package com.haooon.servicefeign.feignstuff;


import com.haooon.servicefeign.feignstuff.hystric.FServiceSysHystric;
import com.haooon.servicefeign.util.HaooonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "service-sys", fallback = FServiceSysHystric.class)
public interface FServiceSys {
    @RequestMapping(value = "/MAIL", method = RequestMethod.POST)
    HaooonResponse mail(@RequestBody Object param);
}