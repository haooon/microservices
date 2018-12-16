package com.haooon.servicesys.service.impl;

import com.haooon.servicesys.params.HParamOPRecord;
import com.haooon.servicesys.service.SOpRecord;
import com.haooon.servicesys.util.HaooonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OPRecordImpl implements SOpRecord {
    /**
     * 所有操作都可以通过redisTemplate来完成
     */
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public HaooonResponse save(HParamOPRecord param) {
        return null;
    }
}
