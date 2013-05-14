package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class IntegerToFloatCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		float f = (Integer)input;
		return f;
	}

}
