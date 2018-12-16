package com.haooon.servicesys.service;

import com.haooon.servicesys.params.HParamOPRecord;
import com.haooon.servicesys.util.HaooonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


public interface SOpRecord {
    public HaooonResponse save(HParamOPRecord param);
}
