package telekinesis.simpledao.mapping.mapper.rowtoobject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RowToObjectMapper<T> {
	public List<T> mapToObjects(ResultSet result) throws SQLException;
}
