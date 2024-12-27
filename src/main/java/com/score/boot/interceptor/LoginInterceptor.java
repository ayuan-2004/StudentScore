package com.score.boot.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.score.boot.model.vo.Uservo;
import com.score.boot.model.vo.studentVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 获取请求的URI
		String requestURI = request.getRequestURI();

		// 允许访问登录页面和登录接口
		if (requestURI.contains("/login.html") ||
				requestURI.contains("/user/teacherLogin") ||
				requestURI.contains("/user/studentLogin") ||
				requestURI.contains("/static/") ||
				requestURI.contains("/assets/")) {
			return true;
		}

		// 检查session中是否有登录信息
		HttpSession session = request.getSession(false);
		if (session != null) {
			// 检查教师登录
			Object teacherLogin = session.getAttribute("teacherLogin");
			if (teacherLogin != null) {
				return true;
			}

			// 检查学生登录
			Object studentLogin = session.getAttribute("studentLogin");
			if (studentLogin != null) {
				return true;
			}
		}

		// 如果未登录，重定向到登录页面
		response.sendRedirect("/login.html");
		return false;
	}
}