package com.ibm.crl.simpledao.mapping.mapper.methodfilter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotatedMethodFilter implements MethodFilter{
	private final Class<? extends Annotation> expectedAnnotation;

	public AnnotatedMethodFilter(Class<? extends Annotation> expectedAnnotation) {
		this.expectedAnnotation = expectedAnnotation;
	}

	@Override
	public boolean accept(Method m) {
		return m.isAnnotationPresent(expectedAnnotation);
	}
	
	
}
