package com.haooon.serviceuser.service;

import com.haooon.serviceuser.entity.User;
import com.haooon.serviceuser.mapper.UserMapper;
import com.haooon.serviceuser.params.LoginParam;
import com.haooon.serviceuser.util.HaooonResponse;
import com.haooon.serviceuser.util.MESSAGEUtil;
import com.haooon.serviceuser.util.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SUserLogin {

    @Autowired
    UserMapper userMapper;

    public HaooonResponse userLogin(LoginParam paramUser){
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
