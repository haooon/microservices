package com.haooon.servicefeign.controller;

import com.haooon.servicefeign.feignstuff.FServiceSys;
import com.haooon.servicefeign.util.HaooonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SysController {
    @Autowired
    FServiceSys feightsys;

    @RequestMapping(value = "/MAIL", method = RequestMethod.POST)
    public HaooonResponse mail(@RequestBody Object param) {
        return feightsys.mail(param);
    }
}
