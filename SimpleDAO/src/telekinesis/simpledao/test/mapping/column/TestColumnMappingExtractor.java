package telekinesis.simpledao.test.mapping.column;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAutoSetterMappingExtractor.class,
		TestCustomizedAutoSetterMappingExtractor.class,
		TestIntLabeledGetterMappingExtractor.class,
		TestIntLabeledSetterMappingExtractor.class,
		TestStringLabeledSetterMappingExtractor.class })
public class TestColumnMappingExtractor {

}
