package com.turling.spring02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 *通知
 */
@Component
@Aspect
public class MyAdvice {
	
//	public void begin(){
//		System.out.println("开启事务");
//	}
//	public void commit(){
//		System.out.println("提交事务");
//	}
	
	@Pointcut("execution(* com.turling.spring02.*Service.*(..))")
	public void pc(){}
	@Before("pc()")
	public void before(){
		System.out.println("before...");
	}
	@After("pc()")
	public void after(){
		System.out.println("after...");
	}
	@AfterReturning("pc()")
	public void afterreturning(){
		System.out.println("after-returning...");
	}
	@AfterThrowing(value="pc()",throwing="th")
	public void afterthrowing(Throwable th){
		System.out.println("afterthrowing..."+th.getMessage());
	}
	
	public Object arround(ProceedingJoinPoint pjp){
		try {
			System.out.println("before");
			Object proceed = pjp.proceed();
			System.out.println("after-returning");
			return proceed;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("afterthrowing");
			e.printStackTrace();
		}finally{
			System.out.println("after");
		}
		return null;
	}
}
