package com.haooon.serviceuser.controller;

import com.haooon.serviceuser.params.LoginParam;
import com.haooon.serviceuser.service.SUserLogin;
import com.haooon.serviceuser.util.HaooonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UserLoginController {

    @Autowired
    SUserLogin login_service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HaooonResponse login(@RequestBody LoginParam param) {
        return login_service.userLogin(param);
    }

    @RequestMapping(value = "/applyforpassword", method = RequestMethod.GET)
    public HaooonResponse applypassword(HttpServletRequest request) {
        return login_service.applyPassword(request);
    }
}
