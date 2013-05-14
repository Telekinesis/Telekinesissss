package com.ibm.crl.simpledao.test.mapping.column;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.crl.simpledao.mapping.mapper.extractor.ColumnMapping;

public class ColumnMappingChecker<T> {
	private final Map<T, ColumnMapping<T>> mappings = new HashMap<T, ColumnMapping<T>>();
	
	public ColumnMappingChecker(List<ColumnMapping<T>> mappings){
		for(ColumnMapping<T> mapping : mappings)
			this.mappings.put(mapping.getLabel(), mapping);
	}
	
	public boolean check(List<ColumnMapping<T>> extractedMappings){
		if(extractedMappings.size() != mappings.size())
			return false;
		for(ColumnMapping<T> mapping : extractedMappings){
			ColumnMapping<T> mappingToCompare = mappings.get(mapping.getLabel());
			if(mappingToCompare == null)
				return false;
			if(!mappingToCompare.getFieldAccessor().equals(mapping.getFieldAccessor())
					|| !mappingToCompare.getFieldType().equals(mapping.getFieldType()))
				return false;
		}
		return true;
	}
}
