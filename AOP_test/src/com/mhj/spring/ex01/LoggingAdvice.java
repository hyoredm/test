package com.mhj.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.jmx.access.InvalidInvocationException;

public class LoggingAdvice implements MethodInterceptor {

	public LoggingAdvice() {

	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 2.
		System.out.println("[메서드 호출 전 : LoggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전");
		Object object = invocation.proceed(); //3.
		
		//4.
		System.out.println("[메서드 호출 후 : LoggingAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 후");
		return object;
	}
	
	

}
