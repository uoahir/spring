package com.bs.spring.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j //롬복있을때만 이 어노테이션 쓸 수 있음 !!!!!

public class AnnoLoggerAspect {
// 1 . target 이 되는 걸 정해야 함 pointcut
// 2 . 어떤 기능을 쓸 거냐 
//	@Pointcut(타겟메소드에 대한 표현식)
	// 메소드 선언
	// 타겟메소드에 대한 표현식 = 반환형 메소드명(패키지명 포함) 
	// 메모 패키지 안에 있는 모든 클래스 안에 있는 모든 메소드 !!!  
	@Pointcut("execution(* com.bs.spring.memo..*(..))") 
	public void test() {}
	
//	@Pointcut("execution(* com.bs.spring..insert*(..))")
//	public void test2() {}
	
	@Pointcut("within(com.bs.spring.demo.controller.DemoController)")
	public void test3() {}
	
	@Before("test()") // aop-context.xml 을 보면, before 에 pointcut-ref 설정해준 거와 같음
	public void loggerTest(JoinPoint jp) {
		log.debug("---- anno aspect before 실행 ----");
	
	}
	
	@After("test()")
	public void loggerTestAfter(JoinPoint jp) {
		Signature sig = jp.getSignature();
		log.debug("끝 냄 : " + sig.getDeclaringTypeName() + "." + sig.getName());
		// getDeclaringTypeName == 클래스명, getName() == 메소드명
		Object[] params= jp.getArgs();
		if(params!=null) {
			for(Object o : params) {
				log.debug("{}",o);
			}
		}
	}
	
//	@Before("test2()") // 여러 개 메소드 적용할 때는 요렇게 
	@Before("execution(* com.bs.spring..insert*(..))") // 하나의 메소드만 적용할 때는 요렇게 
	public void insertLogger(JoinPoint jp) {
		log.debug("--------- insert 메소드 실행 로그 ---------");
		Signature sig = jp.getSignature();
		
		log.debug(sig.getDeclaringTypeName()+"."+sig.getName()+"를 실행");
		Object[] params = jp.getArgs();
		if(params!=null) {
			log.debug("전달된 파라미터");
			for(Object o : params) {
				log.debug("{}", o);
			}
		}
	}
	
	@Before("test3()")
	public void withinTest(JoinPoint jp) {
		log.debug("------ within 시랳ㅇ ------");
	}
	
	
	// Around 적용하기
	// Before, After 동시 적용
	@Around("within(com.bs.spring..dao.*)")
	public Object daoTest(ProceedingJoinPoint jp) throws Throwable{
		// 전 후 로직을 한번에 설정할 수 있음 
		// 지역변수를 전 후에 공유할 수 있음 
		
		// 전에 대한 로직, 후에 대한 로직은 ProceedingJoinPoint 클래스에서 제공하는 proceed() 메소드를 호출한 라인을 기준으로 나눔
		log.debug("==== around before log ====");
		StopWatch watch = new StopWatch();
		watch.start();
		Object obj = jp.proceed();
		
		log.debug("==== around before log ====");
		watch.stop();
		log.debug("실행시간 : " + watch.getTotalTimeMillis() + "ms");
		
		return obj;
	}
	
	@AfterThrowing(value="within(com.bs.spring..controller.*)",
			throwing="e")
	public void afterThrowingLogger(JoinPoint jp, Throwable e) {
		log.debug("==== exception 발생 ! 비상 비상 ! ====");
		Signature sig = jp.getSignature();
		log.error("실행 메소드 : " + sig.getDeclaringTypeName()+"." + sig.getName());
		
		log.error("파라미터");
		Object[] param = jp.getArgs();
		if(param != null) {
			Arrays.stream(param).forEach(p->{
				log.error("{}",p);
			});
		}
		log.error(e.getMessage());
		StackTraceElement[] stackTrace = e.getStackTrace();
		for(StackTraceElement s : stackTrace) {
			log.error("{}",s);
		}
	}
	

	
	
	// 로그를 표시할 때, aop 로 푷시할 수 있음
	// 실행되기 전 또는 실행된 후 (수정 || 삭제) 지연 바보 멍청이 -주환-
	// 모든 update 문에 대해서 이전 기록에 대해 저장시키구 update 한다 ! ? 


}
