package com.ibm.crl.simpledao.test.caster.implementation;

import com.ibm.crl.simpledao.test.caster.InnerCaster;

public class ToStringCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		return String.valueOf(input);
	}

}
