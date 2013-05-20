package telekinesis.simpledao.executor;

import java.util.List;

public interface SqlExecutor<T> {
	public List<T> queryForList(String sql, Class<T> targetType);
	public T queryForObject(String sql, Class<T> targetType);
	public void insert(List<T> objects, String sql);
	public void executeSQL(String sql);
}
