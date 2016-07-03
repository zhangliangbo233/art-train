package com.suning.arttrain.constant;

/**
 * 方法名开头类型
 * 
 * @author zhanglb
 * @version C01 2014年3月11日
 * @since JESHING EBV001R001C01L01
 */
public enum ServiceMethodStartTypeEnum
{

    SAVE(1, "save"),

    DELETE(2, "delete"),

    UPDATE(3, "update");

    public final int code;

    public final String msg;

    private ServiceMethodStartTypeEnum(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }
}
