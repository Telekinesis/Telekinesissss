package com.ibm.crl.simpledao.mapping.mapper.rowtoobject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.crl.simpledao.mapping.mapper.extractor.ColumnMapping;
import com.ibm.crl.simpledao.test.caster.noncasting.NoCastingRuleSet;
import com.ibm.crl.simpledao.typecast.CastHandler;
import com.ibm.crl.simpledao.typecast.CasterTable;
import com.ibm.crl.simpledao.typecast.dbtype.DBTypeTable;

public class StringLabeledMappingHandlerExtractor implements
		MappingHandlerExtractor<String> {
	private final NoCastingRuleSet noCastingRules;
	private final CasterTable casterTable;
	private final DBTypeTable dbTypeMapping;

	public StringLabeledMappingHandlerExtractor(
			NoCastingRuleSet noCastingRules, CasterTable casterTable,
			DBTypeTable dbTypeMapping) {
		this.noCastingRules = noCastingRules;
		this.casterTable = casterTable;
		this.dbTypeMapping = dbTypeMapping;
	}

	@Override
	public List<MappingHandler> extract(
			List<ColumnMapping<String>> columnMappings,
			ResultSet resultSet) throws SQLException {
		ResultSetMetaData metadata = resultSet.getMetaData();
		Map<String, Integer> labelMapping = extractMappingFromStringToIntLabel(metadata);
		List<MappingHandler> handlers = createHandlers(columnMappings, labelMapping, metadata);
		return handlers;
	}
	
	private Map<String, Integer> extractMappingFromStringToIntLabel(ResultSetMetaData metadata) throws SQLException{
		Map<String, Integer> labelMapping = new HashMap<String, Integer>();
		for(int order = 0; order < metadata.getColumnCount(); order++){
			String columnName = metadata.getColumnName(order + 1);
			labelMapping.put(columnName, order + 1);
		}
		return labelMapping;
	}
	
	private List<MappingHandler> createHandlers(List<ColumnMapping<String>> columnMappings, Map<String, Integer> labelMapping, ResultSetMetaData metadata) throws SQLException{
		List<MappingHandler> handlers = new ArrayList<MappingHandler>();
		for(ColumnMapping<String> mapping : columnMappings){
			String label = mapping.getLabel().toUpperCase();
			Integer intLabel = labelMapping.get(label);
			if(intLabel != null){
				int columnType = metadata.getColumnType(intLabel);
				Class<?> sourceType = dbTypeMapping.lookUp(columnType);
				Class<?> targetType = mapping.getFieldType();
				if(noCastingRules.noCastCheck(sourceType, targetType)){
					handlers.add(new MappingHandler(intLabel, mapping.getFieldAccessor(), mapping.getFieldType(), null));
				}else{
					CastHandler caster = casterTable.getCaster(sourceType, targetType);
					handlers.add(new MappingHandler(intLabel, mapping.getFieldAccessor(), mapping.getFieldType(), caster));
				}
			}
		}
		return handlers;
	}

}
