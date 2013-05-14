package telekinesis.simpledao.test.mapping;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import telekinesis.simpledao.executor.jdbctemplate.query.JdbcTemplateBasedQueryer;
import telekinesis.simpledao.mapping.annotation.MapToStringLabel;


public class TestAutoMappingQuery {
	public static class Sample {
		private String id;
		private Timestamp time;
		private int count;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Timestamp getTime() {
			return time;
		}

		public void setTime(Timestamp time) {
			this.time = time;
		}

		public int getCount() {
			return count;
		}

		@MapToStringLabel(label = "amount")
		public void setCount(int count) {
			this.count = count;
		}

		@Override
		public String toString() {
			return "Sample [id=" + id + ", time=" + time + ", count=" + count
					+ "]";
		}

	}
	
	@Test
	public void test(){
		JdbcTemplateBasedQueryer queryer = new JdbcTemplateBasedQueryer();
		List<Sample> sampleList = queryer.queryForList("select id, time, amount from POLYHEDRA.SAMPLE", Sample.class);
		for(Sample s : sampleList)
			System.out.println(s);
	}
}
