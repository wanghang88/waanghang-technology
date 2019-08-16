package com.wanghang.mysql.interceptor;

import com.wanghang.mysql.common.response.Response;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * 这个类我不确定是不是同意的异常处理类
 */
@ControllerAdvice
public class WanghangExceptionHandler extends ResponseEntityExceptionHandler {
		public static final String DEFAULT_ERROR_VIEW = "error";
		private Logger LOG = LogManager.getLogger(WanghangExceptionHandler.class);

		@ResponseBody
		@ExceptionHandler({Exception.class})
		public Response defaultErrorHandler(HttpServletRequest req, Exception e)throws Exception{
			this.LOG.error(e.getMessage(), e);
			return new Response(e.getMessage());
		}
		protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request){
			this.logger.error("the server body:" + body + "httpStatus" + status);
			this.logger.error("the server exception!", ex);
			ResponseEntity<Object> response = super.handleExceptionInternal(ex, body, headers, status, request);
			return response;
		}
}
