package com.ibm.crl.simpledao.test.caster.implementation.boxingnumeric;

import com.ibm.crl.simpledao.test.caster.InnerCaster;

public class ShortToLongCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		long l = (Short)input;
		return l;
	}

}
