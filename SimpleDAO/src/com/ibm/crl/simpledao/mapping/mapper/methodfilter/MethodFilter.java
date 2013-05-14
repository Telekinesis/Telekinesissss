package com.ibm.crl.simpledao.mapping.mapper.methodfilter;

import java.lang.reflect.Method;

public interface MethodFilter {
	public boolean accept(Method m);
}
