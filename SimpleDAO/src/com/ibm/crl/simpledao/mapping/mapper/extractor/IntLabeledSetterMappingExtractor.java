package com.ibm.crl.simpledao.mapping.mapper.extractor;

import java.lang.reflect.Method;
import java.util.List;

import com.ibm.crl.simpledao.mapping.annotation.MapToIntLabel;
import com.ibm.crl.simpledao.mapping.mapper.methodfilter.AnnotatedMethodFilter;
import com.ibm.crl.simpledao.mapping.mapper.methodfilter.ArgumentCountFilter;
import com.ibm.crl.simpledao.mapping.mapper.methodfilter.PrefixFilter;

public class IntLabeledSetterMappingExtractor implements ObjectMappingExtractor<Integer>{

	public List<ColumnMapping<Integer>> extract(Class<?> type){
		ColumnMappingExtractor<Integer> methodTranslator = new ColumnMappingExtractor<Integer>() {
			
			@Override
			public ColumnMapping<Integer> extract(Method m) {
				MapToIntLabel config = m.getAnnotation(MapToIntLabel.class);
				int label = config.label();
				Class<?> fieldType = m.getParameterTypes()[0];
				ColumnMapping<Integer> descriptor = new ColumnMapping<Integer>(label, m, fieldType);
				return descriptor;
			}
		};
		
		MappingExtractor<Integer> translator = new MappingExtractor<Integer>(
				methodTranslator,
				new PrefixFilter("set"),
				new ArgumentCountFilter(1),
				new AnnotatedMethodFilter(MapToIntLabel.class)
				);
		
		List<ColumnMapping<Integer>> mapping = translator.extractColumnMappingForClass(type);
		return mapping;
	}
}
