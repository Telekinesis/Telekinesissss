package telekinesis.simpledao.test.mapping.column;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import telekinesis.simpledao.mapping.annotation.LabelType;
import telekinesis.simpledao.mapping.annotation.MapToIntLabel;
import telekinesis.simpledao.mapping.annotation.QueryMapping;
import telekinesis.simpledao.mapping.mapper.extractor.ColumnMapping;
import telekinesis.simpledao.mapping.mapper.extractor.IntLabeledSetterMappingExtractor;
import telekinesis.simpledao.mapping.mapper.extractor.ObjectMappingExtractor;


public class TestIntLabeledSetterMappingExtractor {
	
	@QueryMapping(labelType = LabelType.INTEGER_LABEL)
	static class Sample {
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

	}
	
	@Test
	public void test() throws NoSuchMethodException, SecurityException{
		ObjectMappingExtractor<Integer> extractor = new IntLabeledSetterMappingExtractor();
		List<ColumnMapping<Integer>> mappings = extractor.extract(Sample.class);
		List<ColumnMapping<Integer>> expectedMapping = new ArrayList<ColumnMapping<Integer>>();
		expectedMapping.add(new ColumnMapping<Integer>(1, Sample.class.getMethod("setId", String.class), String.class));
		expectedMapping.add(new ColumnMapping<Integer>(2, Sample.class.getMethod("setTime", Timestamp.class), Timestamp.class));
		expectedMapping.add(new ColumnMapping<Integer>(3, Sample.class.getMethod("setCount", int.class), int.class));
		ColumnMappingChecker<Integer> checker = new ColumnMappingChecker<Integer>(expectedMapping);
		Assert.assertTrue(checker.check(mappings));
	}
}
