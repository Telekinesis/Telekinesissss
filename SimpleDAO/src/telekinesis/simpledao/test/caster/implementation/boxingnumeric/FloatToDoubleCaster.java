package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class FloatToDoubleCaster implements InnerCaster{

	@Override
	public Object cast(Object input) {
		double d = (Float)input;
		return d;
	}

}
