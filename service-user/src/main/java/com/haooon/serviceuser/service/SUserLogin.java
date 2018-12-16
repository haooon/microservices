package com.haooon.serviceuser.service;


import com.haooon.serviceuser.params.LoginParam;
import com.haooon.serviceuser.util.HaooonResponse;

import javax.servlet.http.HttpServletRequest;


public interface SUserLogin {

    public HaooonResponse userLogin(LoginParam paramUser);

    public HaooonResponse applyPassword(HttpServletRequest request);
}
