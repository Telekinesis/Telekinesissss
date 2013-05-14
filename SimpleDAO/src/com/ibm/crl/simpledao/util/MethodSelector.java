package com.ibm.crl.simpledao.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.ibm.crl.simpledao.mapping.mapper.methodfilter.MethodFilter;

public class MethodSelector {
	private MethodSelector(){}
	
	public static List<Method> select(Class<?> type, MethodFilter... filters){
		List<Method> selected = new ArrayList<Method>();
		Method[] methods = type.getMethods();
		for(Method m : methods){
			if(methodAcceptedByAllFilters(m, filters))
				selected.add(m);
		}
		return selected;
	}
	
	private static boolean methodAcceptedByAllFilters(Method m, MethodFilter... filters){
		for(MethodFilter filter : filters){
			if(!filter.accept(m))
				return false;
		}
		return true;
	}
	
}
