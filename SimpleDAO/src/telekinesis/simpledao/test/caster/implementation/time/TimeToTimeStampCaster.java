package telekinesis.simpledao.test.caster.implementation.time;

import java.sql.Time;
import java.sql.Timestamp;

import telekinesis.simpledao.test.caster.InnerCaster;


public class TimeToTimeStampCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		Time time = (Time)input;
		Timestamp timestamp = new Timestamp(time.getTime());
		return timestamp;
	}

}
