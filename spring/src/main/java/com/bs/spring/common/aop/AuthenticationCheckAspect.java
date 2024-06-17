package com.bs.spring.common.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.bs.spring.common.exception.BadAuthenticationException;
import com.bs.spring.member.model.dto.Member;

@Component
@Aspect
// 얘는 POJO임 !!!! 
public class AuthenticationCheckAspect {
	
//	HttpServletRequest request ,HttpSession session 이거 쓰는 거 외안되나교 ?!
	@Before("execution(* com.bs.spring.memo.model.dao..insert*(..))")
	public void checkAdmin(JoinPoint jp) {
		HttpSession session = (HttpSession)RequestContextHolder.currentRequestAttributes().resolveReference(RequestAttributes.REFERENCE_SESSION);
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		
		if(loginMember ==null || !loginMember.getUserId().equals("admin")) {
			// Exception발생시키기 -> RuntimeException
			throw new BadAuthenticationException("권한이부족합니다.");
		}
	}
	
}
