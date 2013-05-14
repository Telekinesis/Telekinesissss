package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class ByteToDoubleCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		double d = (Byte)input;
		return d;
	}

}
