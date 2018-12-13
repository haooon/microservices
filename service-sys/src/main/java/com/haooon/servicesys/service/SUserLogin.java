package com.haooon.servicesys.service;

import com.haooon.servicesys.entity.User;
import com.haooon.servicesys.mapper.UserMapper;
import com.haooon.servicesys.params.HParamLogin;
import com.haooon.servicesys.util.HaooonResponse;
import com.haooon.servicesys.util.MESSAGEUtil;
import com.haooon.servicesys.util.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SUserLogin {

    @Autowired
    UserMapper userMapper;

    public HaooonResponse userLogin(HParamLogin paramUser){
        HaooonResponse response = new HaooonResponse();
        User userFromDatabase = userMapper.selectByUsername(paramUser.getUsername());
        if(userFromDatabase == null) {
            response.status = "error";
            response.body = MESSAGEUtil.MSG_LOGIN_WRONGUSERNAME;
        }else if(SHA256.encrypt(paramUser.getPassword()).equals(userFromDatabase.getUserPassword())){
            response.status = "success";
            response.body = userFromDatabase.getUserName() + " " + userFromDatabase.getUserPassword();
        }else {
            response.status = "error";
            response.body = MESSAGEUtil.MSG_LOGIN_WRONGPASSWORD;
        }
        return response;
    }
}
