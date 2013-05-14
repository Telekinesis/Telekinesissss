package com.ibm.crl.simpledao.test.caster;


public class Caster {
	private final Class<?> targetClass;
	private final InnerCaster innerCaster;
	
	public Caster(Class<?> targetClass, InnerCaster innerCaster) {
		this.targetClass = targetClass;
		this.innerCaster = innerCaster;
	}

	public Object cast(Object input){
		if(!targetClass.isInstance(input))
			throw new InvalidCasterInputTypeException();
		Object casted = innerCaster.cast(input);
		return casted;
	}
}
