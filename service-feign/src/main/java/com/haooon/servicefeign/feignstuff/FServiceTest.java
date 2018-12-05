package com.haooon.servicefeign.feignstuff;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-test")
public interface FServiceTest {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String testpage(@RequestParam(value = "name") String name);
}
