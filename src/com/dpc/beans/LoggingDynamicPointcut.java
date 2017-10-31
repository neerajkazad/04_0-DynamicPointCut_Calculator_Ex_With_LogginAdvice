package com.dpc.beans;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class LoggingDynamicPointcut extends DynamicMethodMatcherPointcut {

	public boolean matches(Method method, Class classType, Object[] args) {
		if(classType.isAssignableFrom(Calculator.class) && method.getName().equals("add") && (Integer)args[0] > 100 && (Integer)args[1] > 100) {
			return true;
		}
		return false;
	}

}
