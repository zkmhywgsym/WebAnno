package com.yisisoftware.exception;

/**
 * 重复提交异常
 * 
 * @author Administrator
 *
 */
public class DoubleSubmitException extends Exception {

	public DoubleSubmitException() {
		super();
	}

	public DoubleSubmitException(String message) {
		super(message);
	}

}
