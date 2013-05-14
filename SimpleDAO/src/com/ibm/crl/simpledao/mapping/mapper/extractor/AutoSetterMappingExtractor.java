package com.ibm.crl.simpledao.mapping.mapper.extractor;

import java.lang.reflect.Method;
import java.util.List;

import com.ibm.crl.simpledao.mapping.annotation.MapToStringLabel;
import com.ibm.crl.simpledao.mapping.mapper.methodfilter.ArgumentCountFilter;
import com.ibm.crl.simpledao.mapping.mapper.methodfilter.PrefixFilter;

public class AutoSetterMappingExtractor implements ObjectMappingExtractor<String> {
	
	@Override
	public List<ColumnMapping<String>> extract(Class<?> type){
		ColumnMappingExtractor<String> extractor = new ColumnMappingExtractor<String>() {
			
			@Override
			public ColumnMapping<String> extract(Method m) {
				String label = getLabel(m);
				Class<?> fieldType = m.getParameterTypes()[0];
				ColumnMapping<String> descriptor = new ColumnMapping<String>(label, m, fieldType);
				return descriptor;
			}
			
			private String getLabel(Method m){
				String label;
				if(m.isAnnotationPresent(MapToStringLabel.class)){
					MapToStringLabel mapping = m.getAnnotation(MapToStringLabel.class);
					label = mapping.label();
				}else{
					String methodName = m.getName();
					label = methodName.substring(3);
				}
				return label;
			}
			
		};
		
		MappingExtractor<String> descriptorExtractor = new MappingExtractor<String>(
				extractor,
				new PrefixFilter("set"),
				new ArgumentCountFilter(1)
				);
		
		List<ColumnMapping<String>> mapping = descriptorExtractor.extractColumnMappingForClass(type);
		return mapping;
	}

}
