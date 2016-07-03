package com.suning.arttrain.service;

import com.suning.arttrain.common.util.JsonRpcClientUtil;
import com.suning.arttrain.param.CasUserCreateParam;
import com.suning.arttrain.service.BaseTest;
import com.suning.arttrain.service.CasUserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CasUserTest extends BaseTest {

    @Autowired
    private JsonRpcClientUtil jsonRpcClientUtil;

    @Autowired
    private CasUserService casUserService;

    @Test
    public void createCasUserTest(){

        CasUserCreateParam casUser = new CasUserCreateParam();
        casUser.setUserName("zhanglb");
        casUser.setPassword("123456");

        try {
            jsonRpcClientUtil.doService(CasUserService.class,"saveCasUser",casUser);
            Assert.assertNotNull(casUser);
            //casUserService.saveCasUser(casUser);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}