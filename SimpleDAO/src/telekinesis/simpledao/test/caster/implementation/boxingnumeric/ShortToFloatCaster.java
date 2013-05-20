package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class ShortToFloatCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		float f = (Short)input;
		return f;
	}

}
