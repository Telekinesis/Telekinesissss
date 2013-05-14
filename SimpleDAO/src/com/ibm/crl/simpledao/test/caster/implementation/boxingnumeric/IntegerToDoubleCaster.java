package com.ibm.crl.simpledao.test.caster.implementation.boxingnumeric;

import com.ibm.crl.simpledao.test.caster.InnerCaster;

public class IntegerToDoubleCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		double d = (Integer)input;
		return d;
	}

}
