package com.haooon.serviceuser;

import com.haooon.serviceuser.util.SHA256;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SHA256Tests {
    @Test
    public void sha256test() {
        SHA256 sha256 = new SHA256();
        Assert.assertEquals(
                sha256.encrypt("123123"),
                "96cae35ce8a9b0244178bf28e4966c2ce1b8385723a96a6b838858cdd6ca0a1e");
    }
}
