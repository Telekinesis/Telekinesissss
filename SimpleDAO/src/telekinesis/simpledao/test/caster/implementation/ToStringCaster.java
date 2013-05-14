package telekinesis.simpledao.test.caster.implementation;

import telekinesis.simpledao.test.caster.InnerCaster;

public class ToStringCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		return String.valueOf(input);
	}

}
