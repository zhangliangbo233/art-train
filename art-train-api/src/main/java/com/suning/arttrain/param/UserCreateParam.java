package com.suning.arttrain.param;

import java.util.List;

import net.sf.oval.constraint.NotNull;

public class UserCreateParam extends AbstractParam {

	/**
	 * 用户名
	 */
	@NotNull(message = "用户名不能为空")
	private String userName;

	/**
	 * 密码
	 */
	@NotNull(message = "密码不能为空")
	private String password;

	/**
	 * 用户联系电话
	 */
	@NotNull(message = "用户手机号码不能为空")
	private String contactMobile;

	@NotNull(message = "用户类型不能为空")
	private Integer userType;

	/**
	 * 用户角色类型
	 */
	private List<String> roleNames;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

}
