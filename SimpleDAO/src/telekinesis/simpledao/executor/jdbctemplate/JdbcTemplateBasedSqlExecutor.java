package telekinesis.simpledao.executor.jdbctemplate;

import java.util.List;

import telekinesis.simpledao.executor.SqlExecutor;


public class JdbcTemplateBasedSqlExecutor<T> implements SqlExecutor<T>{

	@Override
	public List<T> queryForList(String sql, Class<T> targetType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T queryForObject(String sql, Class<T> targetType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(List<T> objects, String sql) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeSQL(String sql) {
		// TODO Auto-generated method stub
		
	}

}
