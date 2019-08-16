package com.wanghang.mysql.common.untils.exception;



import com.wanghang.mysql.common.enmuns.ErrorCode;
import com.wanghang.mysql.common.response.Response;
import com.wanghang.mysql.common.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
@Order
public class GlobalExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 *  拦截Exception类的异常
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public static Response exceptionHandler(HttpServletRequest request, Exception ex) {
		logger.error("捕获异常,method: " + request.getRequestURI(), ex);

		if(ex instanceof ConstraintViolationException) {
			String message = ex.getMessage().split(":")[1].trim();
			return ResponseUtil.error(message);
		}
		if(ex instanceof MethodArgumentNotValidException){
			MethodArgumentNotValidException e = (MethodArgumentNotValidException) ex;
			FieldError fieldError = e.getBindingResult().getFieldErrors().get(0);
			String defaultMessage = fieldError.getDefaultMessage();
			return ResponseUtil.error(defaultMessage);
		}

		if(ex instanceof ServiceRunTimeException){
			return ResponseUtil.error(ex.getMessage());
		}

		if(ex instanceof IllegalArgumentException){
			return ResponseUtil.error(ex.getMessage());
		}

		if(ex instanceof CheckedException){
			return ResponseUtil.error(ex.getMessage());
		}

		if(ex instanceof ValidateCodeException){
			return ResponseUtil.error(ex.getMessage());
		}
		return ResponseUtil.error(ErrorCode.WRONG_ONSERVER);
	}
}
