package com.wanghang.mysql.common.untils;


import com.wanghang.mysql.common.service.logic.entity.UserVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class UserUtils {
	private static Logger logger = LoggerFactory.getLogger(UserUtils.class);

	public UserUtils(){
	}

	public static String getUserId() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.info("用户解析信息=====" + principal);
		String property = System.getProperty("spring.profiles.active");
		return !property.equals("local") && principal != null ? principal.toString() : "1";
	}

	public static String getUserId(HttpServletRequest httpServletRequest) {
		String token = getToken(httpServletRequest);
		String property = System.getProperty("spring.profiles.active");
		if (!property.equals("local") && !StringUtils.isEmpty(token)) {
			String key = Base64.getEncoder().encodeToString("regs-tms".getBytes());
			Claims claims = (Claims)Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
			logger.info("用户解析信息=====" + claims);
			String userId = claims.get("userId").toString();
			return userId;
		} else {
			return "1";
		}
	}

	public static String getOpenId(HttpServletRequest httpServletRequest) {
		String token = getToken(httpServletRequest);
		String property = System.getProperty("spring.profiles.active");
		if (!property.equals("local") && !StringUtils.isEmpty(token)) {
			String key = Base64.getEncoder().encodeToString("regs-tms".getBytes());
			Claims claims = (Claims)Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
			logger.info("用户解析信息=====" + claims);
			String openId = claims.get("openId").toString();
			return openId;
		} else {
			return "1";
		}
	}

	public static String getTenantId(HttpServletRequest httpServletRequest) {
		String token = getToken(httpServletRequest);
		String property = System.getProperty("spring.profiles.active");
		if (!property.equals("local") && !StringUtils.isEmpty(token)) {
			String key = Base64.getEncoder().encodeToString("regs-tms".getBytes());
			Claims claims = (Claims)Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
			logger.info("用户解析信息=====" + claims);
			String tenantId = claims.get("tenantId").toString();
			return tenantId;
		} else {
			return "D52FAE0A1F08497787B4C6BF29DCB124";
		}
	}


	public static String getTenantCode(HttpServletRequest httpServletRequest) {
		String token = getToken(httpServletRequest);
		String property = System.getProperty("spring.profiles.active");
		if (!property.equals("local") && !StringUtils.isEmpty(token)) {
			String key = Base64.getEncoder().encodeToString("regs-tms".getBytes());
			Claims claims = (Claims)Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
			logger.info("用户解析信息=====" + claims);
			String tenantCode = claims.get("tenantCode").toString();
			return tenantCode;
		} else {
			return "1";
		}
	}


	public static List<String> getRoleIds(HttpServletRequest httpServletRequest) {
		String token = getToken(httpServletRequest);
		String property = System.getProperty("spring.profiles.active");
		if (!property.equals("local") && !StringUtils.isEmpty(token)) {
			String key = Base64.getEncoder().encodeToString("regs-tms".getBytes());
			Claims claims = (Claims)Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
			logger.info("用户解析信息=====" + claims);
			List<String> roleIds = (List)claims.get("authorities");
			return roleIds;
		} else {
			List<String> objects = new ArrayList();
			objects.add("1");
			return objects;
		}
	}


	public static String getToken(HttpServletRequest httpServletRequest) {
		String authorization = httpServletRequest.getHeader("Authorization");
		return StringUtils.substringAfter(authorization, "Bearer ");
	}


	public static UserVo getUserVo(HttpServletRequest httpServletRequest) {
		String token = getToken(httpServletRequest);
		String property = System.getProperty("spring.profiles.active");
		if (!property.equals("local") && !StringUtils.isEmpty(token)) {
			String key = Base64.getEncoder().encodeToString("regs-tms".getBytes());
			Claims claims = (Claims)Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
			logger.info("用户解析信息=====" + claims);
			UserVo userVo = new UserVo();
			userVo.setUserId(safeToString(claims.get("userId")));
			userVo.setTenantId(safeToString(claims.get("tenantId")));
			userVo.setIsAdmin(safeToInteger(claims.get("isAdmin")));
			userVo.setOpenId(safeToString(claims.get("openId")));
			List<String> roleIds = safeToList(claims.get("authorities"));
			userVo.setRoleIds(roleIds);
			return userVo;
		} else {
			UserVo userVo = new UserVo();
			userVo.setUserId("1");
			List<String> objects = new ArrayList();
			objects.add("1");
			userVo.setRoleIds(objects);
			userVo.setTenantId("1");
			return userVo;
		}
	}

	private static String safeToString(Object o) {
		return o == null ? "" : o.toString();
	}

	private static Integer safeToInteger(Object o) {
		return o == null ? 0 : Integer.parseInt(o.toString());
	}

	private static List<String> safeToList(Object o) {
		return (List)(o == null ? new ArrayList() : (List)o);
	}

}
