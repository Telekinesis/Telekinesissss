package com.ibm.crl.simpledao.mapping.mapper.methodfilter;

import java.lang.reflect.Method;

public class ArgumentCountFilter implements MethodFilter {

	private final int argumentCount;

	public ArgumentCountFilter(int argumentCount) {
		this.argumentCount = argumentCount;
	}

	@Override
	public boolean accept(Method m) {
		int argumentCount = m.getParameterTypes().length;
		return argumentCount == this.argumentCount;
	}

}
