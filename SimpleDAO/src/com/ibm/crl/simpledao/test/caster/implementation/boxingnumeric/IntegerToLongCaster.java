package com.ibm.crl.simpledao.test.caster.implementation.boxingnumeric;

import com.ibm.crl.simpledao.test.caster.InnerCaster;

public class IntegerToLongCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		long l = (Integer)input;
		return l;
	}

}
