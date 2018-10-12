package com.learn.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	//testMethod is to be configured as before advice for all 
	//employee methods demonstrating multiple  pointcuts
	//and multiple before advices within a aspect
	public void testMethod() {
		System.out.println("LoggingAspect.testMethod()");
	}
	
	public void beforeAdvice() {
		System.out.println("+++ Before Advice +++");
	}
	
	public void afterAdvice() {
		System.out.println("+++ After Advice +++");
	}
	
	public void afterReturningAdvice(Object retVal) {
		System.out.println("+++ After Returning Advice ::" + retVal.toString());
	}
	
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("+++ After Throwing Advice ::" + ex.toString());
	}
	
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		Object obj = null;
		System.out.println("+++ Around Advice - Before" + joinPoint.getSignature());
		try {
			obj = joinPoint.proceed();
			System.out.println("Around Advice - After" + joinPoint.getSignature());
		} catch (Throwable e) {
			throw e;
		}
		return obj;
	}

}
