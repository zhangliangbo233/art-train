package com.suning.arttrain.dto;


/**
 * 返回给调用接口的对象
 * 
 * @author zhanglb
 * 
 */
public class UserDto
{

    private long userId;

    /**
     * 用户名
     */
    private String userName;

    private int enabled;

    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public int getEnabled()
    {
        return enabled;
    }

    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
    }

}
