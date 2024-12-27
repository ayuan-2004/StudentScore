package com.score.boot.config;


import com.score.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {



	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new LoginInterceptor())

				.addPathPatterns("/**")  // 拦截所有请求

				.excludePathPatterns(

						"/static/**",        // 不拦截静态资源

						"/assets/**",        // 不拦截资源文件

						"/login.html",       // 不拦截登录页面

						"/user/teacherLogin",// 不拦截教师登录接口

						"/user/studentLogin" // 不拦截学生登录接口

				);

	}

}