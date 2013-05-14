package com.ibm.crl.simpledao.mapping.mapper.objecttorow;

public interface ObjectToRowMapper<T> {
	public void mapToRow(T object);
}
