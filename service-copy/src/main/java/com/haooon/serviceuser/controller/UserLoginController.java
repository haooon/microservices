package com.haooon.serviceuser.controller;

import com.haooon.serviceuser.params.LoginParam;
import com.haooon.serviceuser.service.SUserLogin;
import com.haooon.serviceuser.util.HaooonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserLoginController {

    @Autowired
    SUserLogin login_service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HaooonResponse getUser(@RequestBody LoginParam param) {
//        return "123123";
        return login_service.userLogin(param);
    }
}
