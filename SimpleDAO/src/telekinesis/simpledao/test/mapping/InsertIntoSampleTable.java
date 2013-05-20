package telekinesis.simpledao.test.mapping;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Test;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import telekinesis.simpledao.executor.jdbctemplate.JdbcTemplateCreator;


public class InsertIntoSampleTable {
	@Test
	public void test(){
		JdbcTemplate template = JdbcTemplateCreator.create();
		template.batchUpdate("insert into POLYHEDRA.SAMPLE VALUES(?,?,?,?)", new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement statement, int i) throws SQLException {
				statement.setString(1, i + "test");
				statement.setTimestamp(2, new Timestamp(i));
				statement.setString(3, "test");
				statement.setInt(4, i * 50 + 1000);
				statement.addBatch();
			}
			
			@Override
			public int getBatchSize() {
				return 20000;
			}
		});
		
	}
}
