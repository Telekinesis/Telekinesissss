package com.ibm.crl.simpledao.test.caster.implementation.boxingnumeric;

import com.ibm.crl.simpledao.test.caster.InnerCaster;

public class ShortToFloatCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		float f = (Short)input;
		return f;
	}

}
