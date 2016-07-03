package com.suning.arttrain.util;

import org.junit.Assert;

/**
 * 动态获取读写的数据源
 *
 * @author zhanglb
 * @version C01 2014年3月11日
 * @since JESHING EBV001R001C01L01
 */
public class DynamicDataSourceHolder {

    //防止多线程并发
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void setDataSourceName(String dataSourceName) {
        Assert.assertNotNull("dataSourceName can not be null", dataSourceName);
        holder.set(dataSourceName);
    }

    public static String getDataSourceName() {
        return holder.get();
    }
}