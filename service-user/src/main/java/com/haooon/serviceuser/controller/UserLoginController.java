package com.haooon.serviceuser.controller;

import com.haooon.serviceuser.params.LoginParam;
import com.haooon.serviceuser.service.SUserLogin;
import com.haooon.serviceuser.util.HaooonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserLoginController {

    @Autowired
    SUserLogin login_service;

    @RequestMapping("/login")
//    @ResponseBody
    //@RequestBody LoginParam param
    public String getUser() {
        return "123123";
//        return login_service.userLogin(param);
    }
}
