package com.suning.arttrain.exception;

/**
 * 参数校验错误异常类
 * @author zhanglb
 *
 */
public class ParamValidateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParamValidateException(){}
	
	public ParamValidateException(String message){
		super(message);
	}
}
