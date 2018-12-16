package com.haooon.servicesys.service.impl;

import com.haooon.servicesys.params.HParamMail;
import com.haooon.servicesys.service.SMail;
import com.haooon.servicesys.util.HaooonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailImpl implements SMail {
    /**
     * 所有操作都可以通过redisTemplate来完成
     */
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public HaooonResponse send(HParamMail param){
        HaooonResponse response = new HaooonResponse();

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.smtp.host", "smtp.yeah.net");
        props.setProperty("mail.smtp.port", "25");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.timeout", "10000");
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("haooon", "1141135276shR");
            }
        };
        Session session = Session.getInstance(props, auth);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("haooon@yeah.net"));
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(param.getTo()));
            message.setSubject(param.getTitle());
            message.setContent(param.getContent(), "text/html;charset=utf-8");
            Transport.send(message);
        }catch (Exception e){
            response.status = "error";
            response.body = "错误代码:100001,邮件发送失败";
            return response;
        }
        response.status = "success";
        response.body = "邮件发送成功";
        return response;
    }

}
