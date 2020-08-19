package com.georgefuior.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration
	
	@Pointcut("execution(* com.georgefuior.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.georgefuior.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.georgefuior.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage() ")
	private void forAppFlow() {}
	
	//add @Before advice
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method name
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>@Before: Method name: "+ theMethod);
		//display the arguments to the method
		Object[] args = theJoinPoint.getArgs();
		for(Object arg : args) {
			myLogger.info("=======>argument: "+arg);
		}
		
	}

	//add @After advice
	
	@AfterReturning(pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint,Object theResult) {
		
		//display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>@After: Method name: "+ theMethod);
		
		//display the data returned
		myLogger.info("=====>>>Result: "+theResult);
		
		
	}
	

}
