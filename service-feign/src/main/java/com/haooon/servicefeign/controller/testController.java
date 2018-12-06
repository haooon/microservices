package com.haooon.servicefeign.controller;

import com.haooon.servicefeign.feignstuff.FServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Autowired
    FServiceTest feightest;

    @RequestMapping(value = "/test")
    public String test(@RequestParam String name) {
        return feightest.test( name );
    }
}
