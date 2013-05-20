package telekinesis.simpledao.executor.jdbctemplate.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import telekinesis.simpledao.executor.jdbctemplate.JdbcTemplateCreator;
import telekinesis.simpledao.mapping.annotation.LabelType;
import telekinesis.simpledao.mapping.annotation.QueryMapping;
import telekinesis.simpledao.mapping.mapper.extractor.AutoSetterMappingExtractor;
import telekinesis.simpledao.mapping.mapper.extractor.ColumnMapping;
import telekinesis.simpledao.mapping.mapper.extractor.IntLabeledSetterMappingExtractor;
import telekinesis.simpledao.mapping.mapper.extractor.ObjectMappingExtractor;
import telekinesis.simpledao.mapping.mapper.extractor.StringLabeledSetterMappingExtractor;
import telekinesis.simpledao.mapping.mapper.rowtoobject.DefaultRowToObjectMapper;
import telekinesis.simpledao.mapping.mapper.rowtoobject.IntLabeledMappingHandlerExtractor;
import telekinesis.simpledao.mapping.mapper.rowtoobject.MappingHandler;
import telekinesis.simpledao.mapping.mapper.rowtoobject.MappingHandlerExtractor;
import telekinesis.simpledao.mapping.mapper.rowtoobject.RowToObjectMapper;
import telekinesis.simpledao.mapping.mapper.rowtoobject.StringLabeledMappingHandlerExtractor;
import telekinesis.simpledao.test.caster.noncasting.DefaultNoCastingRuleSetCreator;
import telekinesis.simpledao.test.caster.noncasting.NoCastingRuleSet;
import telekinesis.simpledao.typecast.CasterTable;
import telekinesis.simpledao.typecast.DefaultCasterSetCreator;
import telekinesis.simpledao.typecast.dbtype.DBTypeTable;
import telekinesis.simpledao.typecast.dbtype.DefaultDBTypeMappingCreator;


public class JdbcTemplateBasedQueryer {
	private final NoCastingRuleSet noCastingRules = DefaultNoCastingRuleSetCreator.create();
	private final DBTypeTable dbTypeMapping = new DefaultDBTypeMappingCreator().create();
	private final CasterTable casters = DefaultCasterSetCreator.create();
	
	@SuppressWarnings("unchecked")
	public <T> List<T> queryForList(String sql, final Class<T> objectType){
		JdbcTemplate jdbcTemplate = JdbcTemplateCreator.create();
		List<T> result = (List<T>)jdbcTemplate.query(sql, new ResultSetExtractor() {
			
			@Override
			public Object extractData(ResultSet resultSet) throws SQLException,
					DataAccessException {
				if(objectType.isAnnotationPresent(QueryMapping.class)){
					QueryMapping annotation = objectType.getAnnotation(QueryMapping.class);
					LabelType type = annotation.labelType();
					if(type == LabelType.INTEGER_LABEL){
						List<ColumnMapping<Integer>> descriptor = extractColumnMapping(objectType, new IntLabeledSetterMappingExtractor());
						MappingHandlerExtractor<Integer> mappingExtractor = new IntLabeledMappingHandlerExtractor(noCastingRules, casters, dbTypeMapping);
						List<MappingHandler> mappings = mappingExtractor.extract(descriptor, resultSet);
						RowToObjectMapper<T> mapper = new DefaultRowToObjectMapper<T>(mappings, objectType);
						List<T> objects = mapper.mapToObjects(resultSet);
						return objects;
					}else{
						List<ColumnMapping<String>> descriptor = extractColumnMapping(objectType, new StringLabeledSetterMappingExtractor());
						MappingHandlerExtractor<String> mappingExtractor = new StringLabeledMappingHandlerExtractor(noCastingRules, casters, dbTypeMapping);
						List<MappingHandler> mappings = mappingExtractor.extract(descriptor, resultSet);
						RowToObjectMapper<T> mapper = new DefaultRowToObjectMapper<T>(mappings, objectType);
						List<T> objects = mapper.mapToObjects(resultSet);
						return objects;
					}
				}else{
					List<ColumnMapping<String>> descriptor = extractColumnMapping(objectType, new AutoSetterMappingExtractor());
					MappingHandlerExtractor<String> mappingExtractor = new StringLabeledMappingHandlerExtractor(noCastingRules, casters, dbTypeMapping);
					List<MappingHandler> mappings = mappingExtractor.extract(descriptor, resultSet);
					RowToObjectMapper<T> mapper = new DefaultRowToObjectMapper<T>(mappings, objectType);
					List<T> objects = mapper.mapToObjects(resultSet);
					return objects;
				}
			}
			
		});
		return result;
	}
	
	private <I> List<ColumnMapping<I>> extractColumnMapping(Class<?> objectType, ObjectMappingExtractor<I> extractor){
		return extractor.extract(objectType);
	}

}
