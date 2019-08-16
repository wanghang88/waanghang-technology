package com.wanghang.mysql.interceptor;


import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;

import com.wanghang.mysql.common.untils.UserUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Aspect
@Component
public class WanghangWebLogIntercept {
	private static final Logger log = LogManager.getLogger(WanghangWebLogIntercept.class);
	ThreadLocal<Long> startTime = new ThreadLocal();

	@Pointcut("execution(public * com.wanghang.mysql.*.*.controller..*.*(..))")
	public void webLog() {}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint)throws Throwable{
		this.startTime.set(Long.valueOf(System.currentTimeMillis()));

		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		log.info("URL : " + request.getRequestURL().toString());
		log.info("用户USER_ID : " + UserUtils.getUserId(request));
		log.info("HTTP_METHOD : " + request.getMethod());
		log.info("IP : " + request.getRemoteAddr());
		log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		log.info("参数ARGS : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(returning="ret", pointcut="webLog()")
	public void doAfterReturning(Object ret)throws Throwable{
		log.info("SPEND TIME : " + (System.currentTimeMillis() - ((Long)this.startTime.get()).longValue()));
		log.info("返回值RESPONSE : " + ret);
	}

}
