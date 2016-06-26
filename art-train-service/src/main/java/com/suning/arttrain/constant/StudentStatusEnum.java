package com.suning.arttrain.constant;

public enum StudentStatusEnum {

	NORMAL(1,"正常"),DELETED(0,"删除");
	
	private int code;
	
	private String message;
	
	private StudentStatusEnum(int code,String message){
		this.code=code;
		this.message=message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
