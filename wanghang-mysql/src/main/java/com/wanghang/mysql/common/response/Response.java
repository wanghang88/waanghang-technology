package com.wanghang.mysql.common.response;


import com.wanghang.mysql.common.enmuns.ErrorCode;
import com.wanghang.mysql.common.enmuns.ErrorCodeInterface;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

public class Response<T> {
	@ApiModelProperty("返回的状态code:0表示成功,其他表示错误")
	private int code;
	@ApiModelProperty("返回的附加信息")
	private String msg;
	@ApiModelProperty("返回的对象内容")
	private T data;

	public Response() {
		this.code = ErrorCode.SUCCESS.getCode();
		this.msg = ErrorCode.SUCCESS.getMessage();
	}
	public Response(T data, ErrorCodeInterface errorCode) {
		this.data = data;
		if (errorCode == null) {
			this.code = ErrorCode.SUCCESS.getCode();
		} else {
			this.code = errorCode.getCode();
			this.msg = errorCode.getMessage();
		}
	}

	public Response(T data, String mes) {
		this.data = data;
		this.code = 0;
		if (StringUtils.isNotEmpty(mes)) {
			this.msg = mes;
		}
	}

	public Response(T data, String mes, Integer code) {
		this.data = data;
		this.code = code;
		if (StringUtils.isNotEmpty(mes)) {
			this.msg = mes;
		}
	}

	public Response(String message) {
		this.data = null;
		if (message == null) {
			this.code = ErrorCode.ERROR.getCode();
			this.msg = ErrorCode.ERROR.getMessage();
		} else {
			this.code = ErrorCode.ERROR.getCode();
			this.msg = message;
		}
	}

	public void setErrorCode(ErrorCodeInterface errorCode) {
		if (errorCode == null) {
			this.code = ErrorCode.SUCCESS.getCode();
			this.msg = ErrorCode.SUCCESS.getMessage();
		} else {
			this.code = errorCode.getCode();
			this.msg = errorCode.getMessage();
		}
	}

	public int getCode() {
		return this.code;
	}

	public String getMsg() {
		return this.msg;
	}

	public T getData() {
		return this.data;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Response)) {
			return false;
		} else {
			Response<?> other = (Response)o;
			if (!other.canEqual(this)) {
				return false;
			} else if (this.getCode() != other.getCode()) {
				return false;
			} else {
				Object this$msg = this.getMsg();
				Object other$msg = other.getMsg();
				if (this$msg == null) {
					if (other$msg != null) {
						return false;
					}
				} else if (!this$msg.equals(other$msg)) {
					return false;
				}

				Object this$data = this.getData();
				Object other$data = other.getData();
				if (this$data == null) {
					if (other$data != null) {
						return false;
					}
				} else if (!this$data.equals(other$data)) {
					return false;
				}

				return true;
			}
		}
	}
	protected boolean canEqual(Object other) {
		return other instanceof Response;
	}

	public int hashCode() {
		int result = 1;
		result = result * 59 + this.getCode();
		Object $msg = this.getMsg();
		result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
		Object $data = this.getData();
		result = result * 59 + ($data == null ? 43 : $data.hashCode());
		return result;
	}
	public String toString() {
		return "Response(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
	}
}
