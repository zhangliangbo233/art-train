package com.suning.arttrain.param;

import net.sf.oval.constraint.NotNull;

public class CasUserCreateParam extends AbstractParam {

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
