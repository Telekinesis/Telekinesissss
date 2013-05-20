package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class IntegerToDoubleCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		double d = (Integer)input;
		return d;
	}

}
