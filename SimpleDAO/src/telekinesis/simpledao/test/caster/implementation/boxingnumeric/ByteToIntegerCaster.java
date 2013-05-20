package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class ByteToIntegerCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		int i = (Byte)input;
		return i;
	}

}
