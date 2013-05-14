package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class ShortToIntegerCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		int i = (Short)input;
		return i;
	}

}
