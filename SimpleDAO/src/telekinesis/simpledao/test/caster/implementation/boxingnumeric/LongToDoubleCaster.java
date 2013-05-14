package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class LongToDoubleCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		double d = (Long)input;
		return d;
	}

}
