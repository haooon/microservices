package com.haooon.servicefeign.feignstuff;

import com.haooon.servicefeign.feignstuff.hystric.FServiceTestHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-test", fallback = FServiceTestHystric.class)
public interface FServiceTest {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String test(@RequestParam(value = "name") String name);
}
