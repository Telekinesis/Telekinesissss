package telekinesis.simpledao.mapping.mapper.extractor;

import java.lang.reflect.Method;
import java.util.List;

import telekinesis.simpledao.mapping.annotation.MapToIntLabel;
import telekinesis.simpledao.mapping.mapper.methodfilter.AnnotatedMethodFilter;
import telekinesis.simpledao.mapping.mapper.methodfilter.ArgumentCountFilter;
import telekinesis.simpledao.mapping.mapper.methodfilter.PrefixFilter;


public class IntLabeledGetterMappingExtractor implements ObjectMappingExtractor<Integer>{
	
	public List<ColumnMapping<Integer>> extract(Class<?> type){
		ColumnMappingExtractor<Integer> finder = new ColumnMappingExtractor<Integer>() {
			
			@Override
			public ColumnMapping<Integer> extract(Method m) {
				MapToIntLabel config = m.getAnnotation(MapToIntLabel.class);
				int label = config.label();
				Class<?> fieldType = m.getReturnType();
				ColumnMapping<Integer> descriptor = new ColumnMapping<Integer>(label, m, fieldType);
				return descriptor;
			}
		};
		
		MappingExtractor<Integer> translator = new MappingExtractor<Integer>(
				finder,
				new PrefixFilter("get"),
				new ArgumentCountFilter(0),
				new AnnotatedMethodFilter(MapToIntLabel.class)
				);
		
		List<ColumnMapping<Integer>> mapping = translator.extractColumnMappingForClass(type);
		return mapping;
	}
}
