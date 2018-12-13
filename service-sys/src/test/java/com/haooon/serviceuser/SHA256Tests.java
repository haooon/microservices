package com.haooon.serviceuser;

import com.haooon.servicesys.util.SHA256;
import org.junit.Assert;
import org.junit.Test;

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
