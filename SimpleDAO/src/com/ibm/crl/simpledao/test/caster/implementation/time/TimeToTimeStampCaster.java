package com.ibm.crl.simpledao.test.caster.implementation.time;

import java.sql.Time;
import java.sql.Timestamp;

import com.ibm.crl.simpledao.test.caster.InnerCaster;

public class TimeToTimeStampCaster implements InnerCaster {

	@Override
	public Object cast(Object input) {
		Time time = (Time)input;
		Timestamp timestamp = new Timestamp(time.getTime());
		return timestamp;
	}

}
