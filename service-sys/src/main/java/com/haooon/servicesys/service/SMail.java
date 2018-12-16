package com.haooon.servicesys.service;

import com.haooon.servicesys.params.HParamMail;
import com.haooon.servicesys.util.HaooonResponse;


public interface SMail {
    public HaooonResponse send(HParamMail param);
}
