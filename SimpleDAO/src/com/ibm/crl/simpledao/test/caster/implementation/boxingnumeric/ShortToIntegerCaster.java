package com.ibm.crl.simpledao.test.caster.implementation.boxingnumeric;

import com.ibm.crl.simpledao.test.caster.InnerCaster;

public class ShortToIntegerCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		int i = (Short)input;
		return i;
	}

}
