package com.ibm.crl.simpledao.test.caster.implementation.boxingnumeric;

import com.ibm.crl.simpledao.test.caster.InnerCaster;

public class ShortToDoubleCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		double d = (Short)input;
		return d;
	}

}
