package telekinesis.simpledao.test.mapping.column;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import telekinesis.simpledao.mapping.annotation.LabelType;
import telekinesis.simpledao.mapping.annotation.MapToStringLabel;
import telekinesis.simpledao.mapping.annotation.QueryMapping;
import telekinesis.simpledao.mapping.mapper.extractor.ColumnMapping;
import telekinesis.simpledao.mapping.mapper.extractor.ObjectMappingExtractor;
import telekinesis.simpledao.mapping.mapper.extractor.StringLabeledSetterMappingExtractor;


public class TestStringLabeledSetterMappingExtractor {

	@QueryMapping(labelType = LabelType.STRING_LABEL)
	static class Sample {
		private String id;
		private Timestamp time;
		private int count;

		public String getId() {
			return id;
		}

		@MapToStringLabel(label = "1")
		public void setId(String id) {
			this.id = id;
		}

		public Timestamp getTime() {
			return time;
		}

		@MapToStringLabel(label = "2")
		public void setTime(Timestamp time) {
			this.time = time;
		}

		public int getCount() {
			return count;
		}

		@MapToStringLabel(label = "3")
		public void setCount(int count) {
			this.count = count;
		}

	}
	
	@Test
	public void test() throws NoSuchMethodException, SecurityException{
		ObjectMappingExtractor<String> extractor = new StringLabeledSetterMappingExtractor();
		List<ColumnMapping<String>> mappings = extractor.extract(Sample.class);
		List<ColumnMapping<String>> expectedMapping = new ArrayList<ColumnMapping<String>>();
		expectedMapping.add(new ColumnMapping<String>("1", Sample.class.getMethod("setId", String.class), String.class));
		expectedMapping.add(new ColumnMapping<String>("2", Sample.class.getMethod("setTime", Timestamp.class), Timestamp.class));
		expectedMapping.add(new ColumnMapping<String>("3", Sample.class.getMethod("setCount", int.class), int.class));
		ColumnMappingChecker<String> checker = new ColumnMappingChecker<String>(expectedMapping);
		Assert.assertTrue(checker.check(mappings));
	}
}
