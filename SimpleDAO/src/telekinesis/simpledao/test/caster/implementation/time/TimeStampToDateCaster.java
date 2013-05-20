package telekinesis.simpledao.test.caster.implementation.time;

import java.sql.Date;
import java.sql.Timestamp;

import telekinesis.simpledao.test.caster.InnerCaster;


public class TimeStampToDateCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		Timestamp timestamp = (Timestamp)input;
		return new Date(timestamp.getTime());
	}

}
