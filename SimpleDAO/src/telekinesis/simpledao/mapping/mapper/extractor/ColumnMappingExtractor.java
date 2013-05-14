package telekinesis.simpledao.mapping.mapper.extractor;

import java.lang.reflect.Method;

public interface ColumnMappingExtractor<T> {
	public ColumnMapping<T> extract(Method m);
}
