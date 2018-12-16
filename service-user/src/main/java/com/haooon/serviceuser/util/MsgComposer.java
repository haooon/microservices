package com.haooon.serviceuser.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MsgComposer {

    public static String getTime(){
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        return dateFormat.format(calendar.getTime());
    }

    public static String getLoginPassword(String username, String ip, String jumpLink, String freeze){
        String mailContent = "<meta http-equiv='Content-Type' content='text/html; charset=utf-8'/><div style='height:310px;width:640px;background:url(http://39.105.99.88:9876/back.png);background-size:100% 100%;'><div style='color:#FFFFFF;font-size:25px;font-weight:100;padding:20px 0 0 20px;'><strong style='font-weight:400;ont-size:25px;margin-right:10px;'>身份证明</strong>登录密码</div><img src='http://39.105.99.88:9876/icon.png' style='height:30px;width:30px;' hidden/><div style='padding:40px 0 0 20px'><div><strong style='margin-bottom:0;font-size:16px;color:#4A4949;'>登录操作员用户名</strong><p style='margin-top:0;color:#9DA8A8;'>";
        mailContent += username;
        mailContent += "</p></div><div style='width:240px; height:65px;'><div style='width:100px; height:65px;float:left;'><strong style='margin-bottom:0;font-size:16px;color:#4A4949;'>发起登录时间</strong><p style='margin-top:0;color:#9DA8A8;'>";
        mailContent += getTime();
        mailContent += "</p></div><div style='width:120px; height:45px;float:right; padding-left:10px;'><strong style='margin-bottom:0;font-size:16px;color:#4A4949;'>登录使用ip地址</strong><p style='margin-top:0;color:#9DA8A8;'>";
        mailContent += ip;
        mailContent += "</p></div></div><div style='font-size:14px;padding-top:5px;'><a href='";
        mailContent += jumpLink;
        mailContent += "'>确认本人操作，点击此链接跳转登录</a><div style='padding-top:0px;'><a href='";
        mailContent += freeze;
        mailContent += "'>非本人操作，点击此链接临时冻结账户</a></div></div><img src='http://39.105.99.88:9876/identifystamp.png' style='-webkit-transform:rotate(-15deg);margin:-180px 0 0 300px;width:150px;height:150px;'></div></div>";
        return mailContent;
    }
}
