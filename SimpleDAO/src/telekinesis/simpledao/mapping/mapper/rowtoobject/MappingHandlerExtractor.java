package telekinesis.simpledao.mapping.mapper.rowtoobject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import telekinesis.simpledao.mapping.mapper.extractor.ColumnMapping;


public interface MappingHandlerExtractor<T> {
	public List<MappingHandler> extract(List<ColumnMapping<T>> columnMappings,
			ResultSet metadata) throws SQLException;
}
