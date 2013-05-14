package com.ibm.crl.simpledao.executor.jdbctemplate;

import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

public class TestJdbcTemplateConfig {
	private static class Sample {
		final String id;
		final Timestamp time;
		final String name;
		final int amount;

		public Sample(String id, Timestamp time, String name, int amount) {
			this.id = id;
			this.time = time;
			this.name = name;
			this.amount = amount;
		}

		@Override
		public String toString() {
			return "Sample [id=" + id + ", time=" + time + ", name=" + name
					+ ", amount=" + amount + "]";
		}

	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testSelect() {
		JdbcTemplate template = JdbcTemplateCreator.create();
		List<Sample> result = (List<Sample>) template.query(
				"select * from POLYHEDRA.SAMPLE", new ResultSetExtractor() {

					@Override
					public Object extractData(ResultSet result)
							throws SQLException, DataAccessException {
						List<Sample> objects = new ArrayList<Sample>();
						while (result.next()) {
							String id = (String)result.getObject(1);
							Timestamp time = (Timestamp)result.getObject(2);
							String name = (String)result.getObject(3);
							int amount = ((Long)result.getObject(4)).intValue();
							objects.add(new Sample(id, time, name, amount));
						}
						return objects;
					}
				});
		for (Sample object : result)
			System.out.println(object);
	}
	
	@Test
	public void testInsert(){
		JdbcTemplate template = JdbcTemplateCreator.create();
		final List<Sample> samples = new ArrayList<TestJdbcTemplateConfig.Sample>();
		samples.add(new Sample("21", new Timestamp(0), "s1", 0));
		samples.add(new Sample("13", new Timestamp(0), "s2", 0));
		String sql = "insert into POLYHEDRA.SAMPLE VALUES(?,?,?,?)";
		template.execute(sql, new PreparedStatementCallback() {
			
			@Override
			public Object doInPreparedStatement(PreparedStatement statement)
					throws SQLException, DataAccessException {
				ParameterMetaData metaData = statement.getParameterMetaData();
				for(int i = 0; i < metaData.getParameterCount(); i++){
					System.out.println(i+1);
					System.out.println(metaData.getParameterClassName(i+1));
					System.out.println(metaData.getParameterMode(i+1));
					System.out.println(metaData.getParameterType(i+1));
					System.out.println(metaData.getParameterTypeName(i+1));
				}
				for(Sample s : samples){
					statement.setObject(1, s.id);
					statement.setObject(2, s.time);
					statement.setObject(3, s.name);
					statement.setObject(4, s.amount);
					statement.addBatch();
				}
				statement.executeBatch();
				return null;
			}
		});
	}
	
}
