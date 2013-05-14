package com.ibm.crl.simpledao.test.caster.noncasting;


public interface NoCastingRule {
	public boolean isCastNotNeeded(Class<?> inputType, Class<?> parameterType);
}
