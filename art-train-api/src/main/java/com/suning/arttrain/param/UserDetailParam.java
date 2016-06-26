package com.suning.arttrain.param;

import net.sf.oval.constraint.NotNull;

public class UserDetailParam extends AbstractParam {

	@NotNull(when = "groovy:_this.userName==null", message = "用户Id不能为空")
	private Long userId;

	private String userName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
