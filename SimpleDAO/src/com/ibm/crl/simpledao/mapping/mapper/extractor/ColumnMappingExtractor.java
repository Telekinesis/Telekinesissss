package com.ibm.crl.simpledao.mapping.mapper.extractor;

import java.lang.reflect.Method;

public interface ColumnMappingExtractor<T> {
	public ColumnMapping<T> extract(Method m);
}
