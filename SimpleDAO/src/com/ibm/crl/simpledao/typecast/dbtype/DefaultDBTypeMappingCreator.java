package com.ibm.crl.simpledao.typecast.dbtype;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;

public class DefaultDBTypeMappingCreator implements DBTypeMappingLoader {

	@Override
	public DBTypeTable create() {
		DBTypeTable mapping = new DBTypeTable();
		mapping.registMapping(Types.BIGINT, Long.class);
		//Types.BINARY
		mapping.registMapping(Types.BIT, Boolean.class);
		mapping.registMapping(Types.BOOLEAN, Boolean.class);
		mapping.registMapping(Types.CHAR, Character.class);
		mapping.registMapping(Types.DATE, Date.class);
		mapping.registMapping(Types.DECIMAL, BigDecimal.class); //?
		mapping.registMapping(Types.DOUBLE, Double.class);
		mapping.registMapping(Types.FLOAT, Float.class);
		mapping.registMapping(Types.INTEGER, Integer.class);
		mapping.registMapping(Types.LONGNVARCHAR, String.class);
		mapping.registMapping(Types.LONGVARCHAR, String.class);
		mapping.registMapping(Types.NCHAR, String.class); //?
		mapping.registMapping(Types.NUMERIC, Double.class); //?
		mapping.registMapping(Types.NVARCHAR, String.class);
		mapping.registMapping(Types.REAL, Double.class); //?
		mapping.registMapping(Types.SMALLINT, Short.class);
		mapping.registMapping(Types.TIME, Time.class);
		mapping.registMapping(Types.TIMESTAMP, Timestamp.class);
		mapping.registMapping(Types.TINYINT, Byte.class); //?
		mapping.registMapping(Types.VARCHAR, String.class);
		return mapping;
	}

}
