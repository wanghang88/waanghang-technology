package com.wanghang.mysql.common.response;


import com.wanghang.mysql.common.enmuns.ErrorCode;
import com.wanghang.mysql.common.enmuns.ErrorCodeInterface;

public class ResponseUtil {
	public ResponseUtil() {
	}

	public static <T> Response<T> getResponse() {
		Response<T> response = new Response();
		return response;
	}

	public static <T> Response<T> ok() {
		return (Response<T>) ok((Object)null);
	}

	public static <T> Response<T> ok(T data) {
		Response<T> response = null;
		if (data != null) {
			response = new Response(data, ErrorCode.SUCCESS);
		} else {
			response = new Response((Object)null, ErrorCode.SUCCESS);
		}
		return response;
	}

	public static <T> Response<T> ok(T data, String mes) {
		Response<T> response = null;
		if (data != null) {
			response = new Response(data, mes);
		} else {
			response = new Response((Object)null, mes);
		}

		return response;
	}

	public static <T> Response<T> error() {
		Response<T> response = new Response((String)null);
		return response;
	}

	public static <T> Response<T> error(String message) {
		Response<T> response = new Response(message);
		return response;
	}

	public static <T> Response<T> error(ErrorCodeInterface errorCode) {
		return (Response<T>) error(errorCode, (Object)null);
	}

	public static <T> Response<T> error(ErrorCodeInterface errorCode, Object key, Object value) {
		if (key == null) {
			return error(errorCode);
		} else {
			if (value == null) {
				value = "";
			}
			return (Response<T>) error(errorCode, String.format("%s:%s", key, value));
		}
	}

	public static <T> Response<T> error(ErrorCodeInterface errorCode, T data) {
		if (errorCode == null) {
			errorCode = ErrorCode.ERROR;
		}

		return new Response(data, (ErrorCodeInterface)errorCode);
	}
	public static <T> Response<T> errorData(T data, String msg) {
		return new Response(data, msg, 1);
	}

}
