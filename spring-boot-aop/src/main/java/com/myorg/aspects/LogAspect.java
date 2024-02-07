package com.myorg.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	/**
	 * before advice
	 */
	
	@Before("execution(* com.myorg.service.MyService.*(..))")
	public void logBefore() {
		System.out.println("--- Logging Before the service method ---");
	}
	
	
	/**
	 * after advice
	 */
	@After("execution(* com.myorg.service.MyService.*(..))")
	public void logAfter() {
		System.out.println("--- Logging After the service method ---");
	}
}
