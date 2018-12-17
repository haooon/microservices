package com.haooon.serviceuser.service.impl;

import com.haooon.serviceuser.entity.User;
import com.haooon.serviceuser.entity.UserExample;
import com.haooon.serviceuser.entity.UserInfo;
import com.haooon.serviceuser.entity.UserInfoExample;
import com.haooon.serviceuser.mapper.UserInfoMapper;
import com.haooon.serviceuser.mapper.UserMapper;
import com.haooon.serviceuser.params.HParamMail;
import com.haooon.serviceuser.params.LoginParam;
import com.haooon.serviceuser.service.FSys;
import com.haooon.serviceuser.service.SUserLogin;
import com.haooon.serviceuser.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service
public class UserLoginImpl implements SUserLogin {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    FSys sys;

    @Override
    public HaooonResponse userLogin(LoginParam paramUser) {
        HaooonResponse response = new HaooonResponse();
        User userFromDatabase = userMapper.selectByUsername(paramUser.getUsername());
        if(userFromDatabase == null) {
            response.status = "error";
            response.code = "CANTFOUNDUSER";
            response.body = MESSAGEUtil.MSG_LOGIN_WRONGUSERNAME;
        }
//        else if(SHA256.encrypt(paramUser.getPassword()).equals(userFromDatabase.getUserPassword())){
        else if(paramUser.getPassword().equals(userFromDatabase.getUserPassword())){
            response.status = "success";
            response.body = "欢迎：" + userFromDatabase.getUserName();
        }else {
            response.status = "error";
            response.code = "WRONGPASSWORD";
            response.body = MESSAGEUtil.MSG_LOGIN_WRONGPASSWORD;
        }
        return response;
    }

    @Override
    public HaooonResponse applyPassword(HttpServletRequest request) {
        String username = request.getParameter("username");
        HaooonResponse response = new HaooonResponse();
        User user = userMapper.selectByUsername(username);
        if(user == null){
            response.status = "error";
            response.body = "没有查到用户：" + username + "，请检查用户名";
            response.code = "CANTFOUNDUSER";
            return response;
        }else {
            UUID uuid = UUID.randomUUID();
            String password = SHA256.encrypt(uuid.toString().replace("-", ""));

            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUserNameEqualTo(username);
            User newuser = new User();
            newuser.setUserPassword(password);

            HParamMail mail = new HParamMail();
            String ip = NetworkUtil.getIpAddress(request);
            String jumpLink = DATAUTIL.JUMP + password;
            String freeze = DATAUTIL.FREEZE + password;
            String content = MsgComposer.getLoginPassword(username, ip, jumpLink, freeze);
            mail.setContent(content);

            UserInfoExample userInfoExample = new UserInfoExample();
            UserInfoExample.Criteria criteria1 = userInfoExample.createCriteria();
            criteria1.andUserNameEqualTo(username);
            List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
            String to = list.get(0).getUserEmail();
            mail.setTo(to);
            mail.setTitle("登录密码申请结果【申请成功】");
            response = sys.mail(mail);
            if(response.status.equals("error")){
                return response;
            }else {
                userMapper.updateByExampleSelective(newuser,example);
                return response;
            }
        }
    }
}
