package com.haooon.servicesys.controller;

import com.haooon.servicesys.params.HParamMail;
import com.haooon.servicesys.params.HParamOPRecord;
import com.haooon.servicesys.service.impl.MailImpl;
import com.haooon.servicesys.service.impl.OPRecordImpl;
import com.haooon.servicesys.util.HaooonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRelative {

    // 操作记录服务
    @Autowired
    OPRecordImpl record;

    // 邮件服务
    @Autowired
    MailImpl mail;

    /**
     * 接收储存用户操作请求
     * param:{
     *     "OP_USER":"操作用户",
     *     "OP_TYPE":"操作类型",
     *     "OP_CONTENT":"操作内容",
     *     "OP_TIMESTAMP":"操作时间"
     * }
     * @param param
     * @return
     */
    @RequestMapping(value = "/OPRECORD", method = RequestMethod.POST)
    public HaooonResponse getUser(@RequestBody HParamOPRecord param) {
        return record.save(param);
    }


    /**
     * 发送邮件
     * {
     *  "to":"shr1141135276@qq.com",
     *  "from":"haooon@yeah.net",
     *  "title":"login password",
     *  "content":""
     * }
     * @param param
     * @return
     */
    @RequestMapping(value = "/MAIL", method = RequestMethod.POST)
    public HaooonResponse mail(@RequestBody HParamMail param) {
        return mail.send(param);
    }

}
