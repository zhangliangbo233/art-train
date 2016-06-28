package com.suning.arttrain.exception;

/**
 * 参数校验错误异常类
 * @author zhanglb
 *
 */
public class ParamValidateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParamValidateException(){}
	
	public ParamValidateException(String message){
		super(message);
	}
}
