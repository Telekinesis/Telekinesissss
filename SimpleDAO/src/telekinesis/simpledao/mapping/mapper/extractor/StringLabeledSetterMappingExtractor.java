package telekinesis.simpledao.mapping.mapper.extractor;

import java.lang.reflect.Method;
import java.util.List;

import telekinesis.simpledao.mapping.annotation.MapToStringLabel;
import telekinesis.simpledao.mapping.mapper.methodfilter.AnnotatedMethodFilter;
import telekinesis.simpledao.mapping.mapper.methodfilter.ArgumentCountFilter;
import telekinesis.simpledao.mapping.mapper.methodfilter.PrefixFilter;


public class StringLabeledSetterMappingExtractor implements ObjectMappingExtractor<String> {
	
	public List<ColumnMapping<String>> extract(Class<?> type){
		ColumnMappingExtractor<String> mappingExtractor = new ColumnMappingExtractor<String>() {
			
			@Override
			public ColumnMapping<String> extract(Method m) {
				MapToStringLabel config = m.getAnnotation(MapToStringLabel.class);
				String label = config.label();
				Class<?> fieldType = m.getParameterTypes()[0];
				ColumnMapping<String> descriptor = new ColumnMapping<String>(label, m, fieldType);
				return descriptor;
			}
		};
		
		MappingExtractor<String> translator = new MappingExtractor<String>(
				mappingExtractor, 
				new PrefixFilter("set"),
				new ArgumentCountFilter(1),
				new AnnotatedMethodFilter(MapToStringLabel.class)
				);
		
		List<ColumnMapping<String>> mapping = translator.extractColumnMappingForClass(type);
		return mapping;
	}
}
