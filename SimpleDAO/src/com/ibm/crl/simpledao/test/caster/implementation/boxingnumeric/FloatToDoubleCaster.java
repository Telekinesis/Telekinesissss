package com.ibm.crl.simpledao.test.caster.implementation.boxingnumeric;

import com.ibm.crl.simpledao.test.caster.InnerCaster;

public class FloatToDoubleCaster implements InnerCaster{

	@Override
	public Object cast(Object input) {
		double d = (Float)input;
		return d;
	}

}
