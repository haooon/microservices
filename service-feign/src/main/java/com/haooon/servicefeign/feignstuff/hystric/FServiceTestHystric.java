package com.haooon.servicefeign.feignstuff.hystric;

import com.haooon.servicefeign.feignstuff.FServiceTest;
import org.springframework.stereotype.Component;

@Component
public class FServiceTestHystric implements FServiceTest{
    @Override
    public String test(String name) {
        return "sorry service is busy now " + name;
    }
}
