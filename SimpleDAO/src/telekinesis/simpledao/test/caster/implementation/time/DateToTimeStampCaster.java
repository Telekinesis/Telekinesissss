package telekinesis.simpledao.test.caster.implementation.time;

import java.sql.Date;
import java.sql.Timestamp;

import telekinesis.simpledao.test.caster.InnerCaster;


public class DateToTimeStampCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		Date date = (Date)input;
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}

}
