package com.bs.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String index(HttpSession session, HttpServletResponse response) {
		
		// log4j 가 제공하는 Logger를 이용해서 로그메세지 출력하기
		// debug > info > warn > error -> level ? 
		// debug()
		// info()
		// warn()
		// error()
		
		logger.debug("debug 로그 출력");
		logger.info("info 로그 출력");
		logger.warn("warn 로그 출력");
		logger.error("error 로그 출력");
		
		session.setAttribute("sessionId", "GDJ79");
		Cookie c = new Cookie("cookieData","cookiecookie");
		c.setMaxAge(60*60*24);
		response.addCookie(c);
		return "index";
	}
	
}
