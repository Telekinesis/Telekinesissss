package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class ByteToLongCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		long l = (Byte)input;
		return l;
	}

}
