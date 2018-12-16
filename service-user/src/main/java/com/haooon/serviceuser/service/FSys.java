package com.haooon.serviceuser.service;


import com.haooon.serviceuser.service.impl.HytrisSys;
import com.haooon.serviceuser.util.HaooonResponse;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "service-sys", fallback = HytrisSys.class)
public interface FSys {
    @RequestMapping(value = "/MAIL", method = RequestMethod.POST)
    HaooonResponse mail(@RequestBody Object param);
}
