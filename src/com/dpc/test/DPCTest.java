package com.dpc.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.dpc.beans.Calculator;
import com.dpc.beans.LoggingAdvice;
import com.dpc.beans.LoggingDynamicPointcut;


public class DPCTest {
	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new Calculator());
		pf.addAdvisor(new DefaultPointcutAdvisor(new LoggingDynamicPointcut(), new LoggingAdvice()));
		
		Calculator proxy = (Calculator) pf.getProxy();
		int sum = proxy.add(101, 201);
		System.out.println("Sum: "+sum);
		
		int mul = proxy.multiply(10, 5);
		System.out.println("Multiply: "+mul);
		
	}
}
