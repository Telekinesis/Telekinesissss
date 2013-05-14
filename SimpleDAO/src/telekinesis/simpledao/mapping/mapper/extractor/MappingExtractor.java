package telekinesis.simpledao.mapping.mapper.extractor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import telekinesis.simpledao.mapping.mapper.methodfilter.MethodFilter;
import telekinesis.simpledao.util.MethodSelector;


public class MappingExtractor<T> {
	
	private ColumnMappingExtractor<T> mappingExtractor;
	private MethodFilter[] accessorFilters;

	public MappingExtractor(ColumnMappingExtractor<T> mappingExtractor, MethodFilter... accessorFilters) {
		this.mappingExtractor = mappingExtractor;
		this.accessorFilters = accessorFilters;
	}

	public List<ColumnMapping<T>> extractColumnMappingForClass(Class<?> type) {
		List<ColumnMapping<T>> mappings = new ArrayList<ColumnMapping<T>>();
		List<Method> fieldAccessors = MethodSelector.select(type, accessorFilters);
		for(Method accessor : fieldAccessors){
			ColumnMapping<T> descriptor = mappingExtractor.extract(accessor);
			mappings.add(descriptor);
		}
		return mappings;
	}
	
}
