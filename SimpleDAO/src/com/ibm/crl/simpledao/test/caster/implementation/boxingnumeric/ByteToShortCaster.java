package com.ibm.crl.simpledao.test.caster.implementation.boxingnumeric;

import com.ibm.crl.simpledao.test.caster.InnerCaster;

public class ByteToShortCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		short s = (Byte)input; 
		return s;
	}

}
