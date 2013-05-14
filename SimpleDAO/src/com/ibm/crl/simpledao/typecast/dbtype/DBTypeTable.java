package com.ibm.crl.simpledao.typecast.dbtype;

import java.util.HashMap;
import java.util.Map;

public class DBTypeTable {
	private final Map<Integer, Class<?>> mapping = new HashMap<Integer, Class<?>>();
	
	public void registMapping(int dbType, Class<?> javaType){
		mapping.put(dbType, javaType);
	}
	
	public Class<?> lookUp(int dbType) throws InvalidDBTypeCodeException{
		Class<?> type = mapping.get(dbType);
		if(type == null)
			throw new InvalidDBTypeCodeException(dbType);
		return type;
	}
}
