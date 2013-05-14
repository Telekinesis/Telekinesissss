package telekinesis.simpledao.executor.jdbctemplate.insert;

import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import telekinesis.simpledao.executor.jdbctemplate.JdbcTemplateCreator;
import telekinesis.simpledao.test.caster.noncasting.DefaultNoCastingRuleSetCreator;
import telekinesis.simpledao.test.caster.noncasting.NoCastingRuleSet;
import telekinesis.simpledao.typecast.CasterTable;
import telekinesis.simpledao.typecast.DefaultCasterSetCreator;
import telekinesis.simpledao.typecast.dbtype.DBTypeTable;
import telekinesis.simpledao.typecast.dbtype.DefaultDBTypeMappingCreator;


public class JdbcTemplateBasedInserter {
	private final NoCastingRuleSet noCastingRules = DefaultNoCastingRuleSetCreator.create();
	private final DBTypeTable dbTypeMapping = new DefaultDBTypeMappingCreator().create();
	private final CasterTable casters = DefaultCasterSetCreator.create();
	
	public <T> void insert(String sql, final List<T> objects){
		if(objects == null || objects.isEmpty())
			return;
		final Class<?> objectType = objects.get(0).getClass();
		JdbcTemplate template = JdbcTemplateCreator.create();
		template.batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement statement, int arg1) throws SQLException {
				ParameterMetaData metaData = statement.getParameterMetaData();
				
			}
			
			@Override
			public int getBatchSize() {
				return objects.size();
			}
		});
	}
}
