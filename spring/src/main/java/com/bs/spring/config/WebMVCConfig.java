package com.bs.spring.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.bs.spring.common.exception.BadAuthenticationException;

@Configuration
@EnableWebMvc
public class WebMVCConfig implements WebMvcConfigurer{
	
	// 예외처리할 bean을 등록해서 활용할 수 있ㅇ음
	// HandlerExceptionResolver 를 구현한 구현체
	@Bean
	public HandlerExceptionResolver handleException() {
		SimpleMappingExceptionResolver smer = new SimpleMappingExceptionResolver();
		
		Properties mappingException = new Properties();
		
		mappingException.setProperty(BadAuthenticationException.class.getName(), "common/error/authentication");
		smer.setExceptionMappings(mappingException);
		
		smer.setDefaultErrorView("common/error/error");
		
		return smer;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/board/boardwrite.do").setViewName("board/boardwrite");
		// 위 주소로 요청이 들어오면 ~ 얘가 알아서 board/boardwrite.jsp 와 연결해준ㅁ다 ?!
	}
	
	
}
