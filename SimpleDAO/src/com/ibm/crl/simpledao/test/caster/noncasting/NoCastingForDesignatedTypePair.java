package com.ibm.crl.simpledao.test.caster.noncasting;

import java.util.List;

import com.ibm.crl.simpledao.util.KeyToValueList;

public class NoCastingForDesignatedTypePair implements NoCastingRule {
	
	private KeyToValueList<Class<?>, Class<?>> designatedPairs = new KeyToValueList<Class<?>, Class<?>>();
	
	public NoCastingForDesignatedTypePair add(Class<?> from, Class<?> to){
		designatedPairs.put(from, to);
		return this;
	}
	
	public NoCastingForDesignatedTypePair addBidirectionally(Class<?> c1, Class<?> c2){
		designatedPairs.put(c1, c2);
		designatedPairs.put(c2, c1);
		return this;
	}
	
	@Override
	public boolean isCastNotNeeded(Class<?> inputType, Class<?> parameterType) {
		List<Class<?>> noCastingCandidates = designatedPairs.get(inputType);
		return noCastingCandidates.contains(parameterType);
	}

}
