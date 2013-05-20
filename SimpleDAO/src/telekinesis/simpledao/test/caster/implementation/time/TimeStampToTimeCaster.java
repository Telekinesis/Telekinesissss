package telekinesis.simpledao.test.caster.implementation.time;

import java.sql.Time;
import java.sql.Timestamp;

import telekinesis.simpledao.test.caster.InnerCaster;


public class TimeStampToTimeCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		Timestamp timestamp = (Timestamp)input;
		return new Time(timestamp.getTime());
	}

}
