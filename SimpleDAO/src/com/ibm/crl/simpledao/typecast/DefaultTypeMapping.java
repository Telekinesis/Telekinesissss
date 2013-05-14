package com.ibm.crl.simpledao.typecast;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class DefaultTypeMapping {
	private DefaultTypeMapping(){}
	
	private static Map<Integer, Class<?>> dbTypeMapping = new HashMap<Integer, Class<?>>();
	
	static{
		dbTypeMapping.put(Types.BIGINT, Long.class);
		//Types.BINARY
		dbTypeMapping.put(Types.BIT, Boolean.class);
		dbTypeMapping.put(Types.BOOLEAN, Boolean.class);
		dbTypeMapping.put(Types.CHAR, Character.class);
		dbTypeMapping.put(Types.DATE, Date.class);
		dbTypeMapping.put(Types.DECIMAL, BigDecimal.class); //?
		dbTypeMapping.put(Types.DOUBLE, Double.class);
		dbTypeMapping.put(Types.FLOAT, Float.class);
		dbTypeMapping.put(Types.INTEGER, Integer.class);
		dbTypeMapping.put(Types.LONGNVARCHAR, String.class);
		dbTypeMapping.put(Types.LONGVARCHAR, String.class);
		dbTypeMapping.put(Types.NCHAR, String.class); //?
		dbTypeMapping.put(Types.NUMERIC, Double.class); //?
		dbTypeMapping.put(Types.NVARCHAR, String.class);
		dbTypeMapping.put(Types.REAL, Double.class); //?
		dbTypeMapping.put(Types.SMALLINT, Short.class);
		dbTypeMapping.put(Types.TIME, Time.class);
		dbTypeMapping.put(Types.TIMESTAMP, Timestamp.class);
		dbTypeMapping.put(Types.TINYINT, Byte.class); //?
		dbTypeMapping.put(Types.VARCHAR, String.class);
	}
}
