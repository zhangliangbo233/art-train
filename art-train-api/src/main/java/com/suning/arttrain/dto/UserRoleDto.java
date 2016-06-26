package com.suning.arttrain.dto;

/**
 * 返回给调用接口的对象
 * 
 * @author zhanglb
 * 
 */
public class UserRoleDto
{

    private long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户角色
     */
    private String roleName;

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

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
   
}
