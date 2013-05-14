package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class ByteToFloatCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		float f = (Byte)input;
		return f;
	}

}
