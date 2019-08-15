package com.wanghang.mysql.common.service.logic.entity;


import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.wanghang.mysql.common.enmuns.ErrorCode;
import com.wanghang.mysql.common.response.Response;
import com.wanghang.mysql.common.response.ResponseUtil;
import com.wanghang.mysql.common.untils.UserUtils;
import com.wanghang.mysql.common.untils.exception.ServiceRunTimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private HttpServletRequest request;

	@ExceptionHandler
	@ResponseBody
	public Response exceptionHandler(HttpServletRequest request, Exception ex){
		this.logger.error("捕获异常,method: " + request.getRequestURI(), ex);
		if ((ex instanceof ServiceRunTimeException)){
			if (((ServiceRunTimeException)ex).getErrorCode() != null){
				ServiceRunTimeException srte = (ServiceRunTimeException)ex;
				return ResponseUtil.error(srte.getErrorCode());
			}
			this.logger.error(ex.getMessage(), ex);

			return ResponseUtil.error(ex.getMessage());
		}
		if ((ex instanceof HystrixRuntimeException)){
			if ((ex.getCause().getMessage().contains("Load balancer does not have available server for client")) ||
					(ex.getCause().getMessage().contains("Connection refused"))) {
				return ResponseUtil.error(ErrorCode.WRONG_ONSERVER);
			}
			return ResponseUtil.error(ex.getCause().getMessage());
		}
		return ResponseUtil.error(ErrorCode.WRONG_ONSERVER);
	}

	public HttpServletRequest getRequest(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		if (request == null) {
			request = this.request;
		}
		return request;
	}

	public List<String> getRoleIds(){
		return UserUtils.getRoleIds(this.request);
	}

	public String getTenantId(){
		return UserUtils.getTenantId(this.request);
	}

	public String getUserId(){
		return UserUtils.getUserId(this.request);
	}

	public UserVo getUserVo(){
		return UserUtils.getUserVo(this.request);
	}

	public String getTenantCode(){
		return UserUtils.getTenantCode(this.request);
	}
}
