package telekinesis.simpledao.test.caster.implementation.boxingnumeric;

import telekinesis.simpledao.test.caster.InnerCaster;

public class ByteToShortCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		short s = (Byte)input; 
		return s;
	}

}
