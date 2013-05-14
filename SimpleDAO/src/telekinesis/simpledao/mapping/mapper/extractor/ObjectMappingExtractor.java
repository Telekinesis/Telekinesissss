package telekinesis.simpledao.mapping.mapper.extractor;

import java.util.List;

public interface ObjectMappingExtractor<T> {
	public List<ColumnMapping<T>> extract(Class<?> type);
}
