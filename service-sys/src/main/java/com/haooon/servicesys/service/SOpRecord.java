package com.haooon.servicesys.service;

import com.haooon.servicesys.params.HParamOPRecord;
import com.haooon.servicesys.util.HaooonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SOpRecord {
    /**
     * 所有操作都可以通过redisTemplate来完成
     */
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public HaooonResponse save(HParamOPRecord param){
        return new HaooonResponse();
    }
}
