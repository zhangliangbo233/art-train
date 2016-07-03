package com.suning.arttrain.common.exception;

public class AbstractException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 583570023294617142L;

	public AbstractException() {
		super();
	}

	public AbstractException(String errorMsg) {
		super(errorMsg);
	}
}
