package com.suning.arttrain.persistent;

/**
 * UserRole实体对象
 * 
 * @author zhanglb
 * 
 */
public class UserRole {

	private long id;

	private long userId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 用户角色
	 */
	private String roleName;

	public UserRole() {
	}

	public UserRole(long userId, String userName, String roleName) {
		this.userId = userId;
		this.userName = userName;
		this.roleName = roleName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
