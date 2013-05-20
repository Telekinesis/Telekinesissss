package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class ShortToLongCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		long l = (Short)input;
		return l;
	}

}
