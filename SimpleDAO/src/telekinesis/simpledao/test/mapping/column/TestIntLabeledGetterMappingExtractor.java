package telekinesis.simpledao.test.mapping.column;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import telekinesis.simpledao.mapping.annotation.MapToIntLabel;
import telekinesis.simpledao.mapping.annotation.UpdateMapping;
import telekinesis.simpledao.mapping.mapper.extractor.ColumnMapping;
import telekinesis.simpledao.mapping.mapper.extractor.IntLabeledGetterMappingExtractor;
import telekinesis.simpledao.mapping.mapper.extractor.ObjectMappingExtractor;


public class TestIntLabeledGetterMappingExtractor {
	
	@UpdateMapping
	static class Sample {
		private String id;
		private Timestamp time;
		private int count;

		@MapToIntLabel(label = 1)
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		@MapToIntLabel(label = 2)
		public Timestamp getTime() {
			return time;
		}

		public void setTime(Timestamp time) {
			this.time = time;
		}

		@MapToIntLabel(label = 3)
		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

	}
	
	@Test
	public void test() throws NoSuchMethodException, SecurityException{
		ObjectMappingExtractor<Integer> extractor = new IntLabeledGetterMappingExtractor();
		List<ColumnMapping<Integer>> mappings = extractor.extract(Sample.class);
		List<ColumnMapping<Integer>> expectedMapping = new ArrayList<ColumnMapping<Integer>>();
		expectedMapping.add(new ColumnMapping<Integer>(1, Sample.class.getMethod("getId"), String.class));
		expectedMapping.add(new ColumnMapping<Integer>(2, Sample.class.getMethod("getTime"), Timestamp.class));
		expectedMapping.add(new ColumnMapping<Integer>(3, Sample.class.getMethod("getCount"), int.class));
		ColumnMappingChecker<Integer> checker = new ColumnMappingChecker<Integer>(expectedMapping);
		Assert.assertTrue(checker.check(mappings));
	}
}
