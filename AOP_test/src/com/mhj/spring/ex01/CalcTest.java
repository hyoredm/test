package com.mhj.spring.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		// 1. 프로젝트 명  => src => "AOPTest.xml"
		ApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml");
		
		// 2.
		Calculator cal = (Calculator) context.getBean("proxyCal");
		
		// 3.
		cal.add(100, 20);
		System.out.println();
		
		/*
		 * cal.subtract(100, 20); System.out.println();
		 * 
		 * cal.multiply(100, 20); System.out.println();
		 * 
		 * cal.divide(100, 20); System.out.println();
		 */

	}

}
