package com.ibm.crl.simpledao.mapping.mapper.rowtoobject;

import java.lang.reflect.Method;

import com.ibm.crl.simpledao.typecast.CastHandler;

public class MappingHandler {
	final int label;
	final Method fieldAccessor;
	final Class<?> fieldType;
	final CastHandler caster;

	public MappingHandler(int label, Method fieldAccessor, Class<?> fieldType,
			CastHandler caster) {
		this.label = label;
		this.fieldAccessor = fieldAccessor;
		this.fieldType = fieldType;
		this.caster = caster;
	}

}
