package com.suning.arttrain.exception;

import com.suning.arttrain.common.exception.AbstractException;

/**
 * 参数校验错误异常类
 * @author zhanglb
 *
 */
public class ParamValidateException extends AbstractException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParamValidateException(){}
	
	public ParamValidateException(String message){
		super(message);
	}
}
