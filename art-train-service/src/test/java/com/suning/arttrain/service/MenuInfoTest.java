package com.suning.arttrain.service;

import com.suning.arttrain.persistent.MenuInfo;
import com.suning.arttrain.service.BaseTest;
import com.suning.arttrain.service.MenuInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhanglb on 14-8-10.
 */
public class MenuInfoTest extends BaseTest {

    @Autowired
    private MenuInfoService menuInfoService;

    @Test
    public void listMenuInfosTest(){

        List<MenuInfo> menuInfos = menuInfoService.listMenuInfos(0l);

        Assert.assertNotNull(menuInfos);
    }
}
