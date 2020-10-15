package com.turling.spring01;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 *通知
 */
public class MyAdvice {
	
//	public void begin(){
//		System.out.println("开启事务");
//	}
//	public void commit(){
//		System.out.println("提交事务");
//	}
	
	
	public void before(){
		System.out.println("before...");
	}
	public void after(){
		System.out.println("after...");
	}
	
	public void afterreturning(){
		System.out.println("after-returning...");
	}
	
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
