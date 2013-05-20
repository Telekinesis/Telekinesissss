package telekinesis.simpledao.test.mapping.column;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import telekinesis.simpledao.mapping.mapper.extractor.AutoSetterMappingExtractor;
import telekinesis.simpledao.mapping.mapper.extractor.ColumnMapping;
import telekinesis.simpledao.mapping.mapper.extractor.ObjectMappingExtractor;


public class TestAutoSetterMappingExtractor {

	static class Sample {
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

		public void setCount(int count) {
			this.count = count;
		}

	}

	@Test
	public void test() throws NoSuchMethodException, SecurityException {
		ObjectMappingExtractor<String> extractor = new AutoSetterMappingExtractor();
		List<ColumnMapping<String>> mappings = extractor.extract(Sample.class);
		List<ColumnMapping<String>> expectedMapping = new ArrayList<ColumnMapping<String>>();
		expectedMapping.add(new ColumnMapping<String>("Id", Sample.class.getMethod("setId", String.class), String.class));
		expectedMapping.add(new ColumnMapping<String>("Time", Sample.class.getMethod("setTime", Timestamp.class), Timestamp.class));
		expectedMapping.add(new ColumnMapping<String>("Count", Sample.class.getMethod("setCount", int.class), int.class));
		ColumnMappingChecker<String> checker = new ColumnMappingChecker<String>(expectedMapping);
		Assert.assertTrue(checker.check(mappings));
	}
}
