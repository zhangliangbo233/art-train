package com.suning.arttrain.constant;

/**
 * 数据库读写分离动态数据源切换
 * 
 * Created by zhanglb on 14-2-8.
 */
public enum DataSourceReadAndWriteEnum
{
    DATA_SOURCE_MASTER(1, "master"),

    DATA_SOURCE_SLAVE(2, "slave");

    public final int code;

    public final String dataSource;

    private DataSourceReadAndWriteEnum(int code, String dataSource)
    {
        this.code = code;
        this.dataSource = dataSource;
    }
}
