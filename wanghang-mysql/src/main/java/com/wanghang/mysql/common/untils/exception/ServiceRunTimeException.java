package com.wanghang.mysql.common.untils.exception;

import com.wanghang.mysql.common.enmuns.ErrorCodeInterface;

public class ServiceRunTimeException extends RuntimeException {

	private ErrorCodeInterface errorCode;
	private static final long serialVersionUID = 3297894301127542570L;

	public ServiceRunTimeException() {
	}
	public ServiceRunTimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceRunTimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceRunTimeException(String message) {
		super(message);
	}

	public ServiceRunTimeException(Throwable cause) {
		super(cause);
	}

	public ServiceRunTimeException(String message, int code) {
		super(message);
	}

	public ServiceRunTimeException(ErrorCodeInterface errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public ErrorCodeInterface getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(ErrorCodeInterface errorCode) {
		this.errorCode = errorCode;
	}
}
