package com.turling.spring02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(Test.class);
		StudentService stuService=(StudentService)ctx.getBean("studentService");
		stuService.add();
	}
}
