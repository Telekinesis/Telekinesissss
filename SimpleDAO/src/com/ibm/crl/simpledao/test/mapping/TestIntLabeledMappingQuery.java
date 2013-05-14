package com.ibm.crl.simpledao.test.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ibm.crl.simpledao.executor.jdbctemplate.JdbcTemplateCreator;
import com.ibm.crl.simpledao.executor.jdbctemplate.query.JdbcTemplateBasedQueryer;
import com.ibm.crl.simpledao.mapping.annotation.LabelType;
import com.ibm.crl.simpledao.mapping.annotation.MapToIntLabel;
import com.ibm.crl.simpledao.mapping.annotation.QueryMapping;

public class TestIntLabeledMappingQuery {
	private JdbcTemplate template = JdbcTemplateCreator.create();
	
	@QueryMapping(labelType = LabelType.INTEGER_LABEL)
	public static class Sample {
		private String id;
		private Timestamp time;
		private int count;

		public String getId() {
			return id;
		}

		@MapToIntLabel(label = 1)
		public void setId(String id) {
			this.id = id;
		}

		public Timestamp getTime() {
			return time;
		}

		@MapToIntLabel(label = 2)
		public void setTime(Timestamp time) {
			this.time = time;
		}

		public int getCount() {
			return count;
		}

		@MapToIntLabel(label = 3)
		public void setCount(int count) {
			this.count = count;
		}

		@Override
		public String toString() {
			return "Sample [id=" + id + ", time=" + time + ", count=" + count
					+ "]";
		}

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void queryByJdbcTemplate(){
		
		List<Sample> sampleList = (List<Sample>)template.query("select id, time, amount from POLYHEDRA.SAMPLE", new ResultSetExtractor() {
			@Override
			public Object extractData(ResultSet result)
					throws SQLException, DataAccessException {
				List<Sample> objects = new ArrayList<Sample>();
				while (result.next()) {
					String id = result.getString(1);
					Timestamp time = result.getTimestamp(2);
					int amount = result.getInt(3);
					Sample s = new Sample();
					s.setId(id);
					s.setTime(time);
					s.setCount(amount);
					objects.add(s);
				}
				return objects;
			}
		});
		System.out.println(sampleList.size());
	}
	
	@Test
	public void queryByReflection(){
		JdbcTemplateBasedQueryer queryer = new JdbcTemplateBasedQueryer();
		List<Sample> sampleList = queryer.queryForList("select id, time, amount from POLYHEDRA.SAMPLE", Sample.class);
		System.out.println(sampleList.size());
	}
}
