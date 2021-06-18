package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.Interceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private Interceptor interceptador;
		
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(interceptador).addPathPatterns("/**");
	}

}
