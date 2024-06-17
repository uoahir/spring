package com.bs.spring.common.aop;

import java.lang.reflect.Field;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerAspect {
	
	// 공통의 기능을 정의 -> 메소드
	// 메소드 선언방식이 정해져있음
	// void 메소드명(JoinPoint)
	// Around -> Object 메소드명(ProceedingJoinPoint)
	
	public void loggerBefore(JoinPoint jp) {
		log.debug("----- aop before 메소드 실행 -----");
//		log.debug("실행실행");
		// 어떤 클래스의 어떤 메소드가 실행되는 건지 확인
		// JoinPoint객체는 target 메소드의 각종 정보를 저장하고 있는 객체
		// target 메소드의 클래스, 메소드 정보 가져오기 -> Signature 객체를 이용
		Signature sig = jp.getSignature();
		log.debug("클래스명 : " + sig.getDeclaringTypeName());
		log.debug("메소드명 : " + sig.getName());
		Class targetClass = sig.getDeclaringType();
		for(Field f : targetClass.getDeclaredFields()) {
			log.debug(f.getName());
		}
		log.debug("--------------------------------");
		
	}
	
	public void loggerAfter(JoinPoint jp) {
		log.debug("------- aop after 메소드 실행 -------");
		log.debug("-----------------------------------");
	}
}
