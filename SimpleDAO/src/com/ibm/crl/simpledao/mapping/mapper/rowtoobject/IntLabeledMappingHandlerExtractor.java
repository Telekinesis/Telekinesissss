package com.ibm.crl.simpledao.mapping.mapper.rowtoobject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.crl.simpledao.mapping.mapper.extractor.ColumnMapping;
import com.ibm.crl.simpledao.test.caster.noncasting.NoCastingRuleSet;
import com.ibm.crl.simpledao.typecast.CastHandler;
import com.ibm.crl.simpledao.typecast.CasterTable;
import com.ibm.crl.simpledao.typecast.dbtype.DBTypeTable;

public class IntLabeledMappingHandlerExtractor implements
		MappingHandlerExtractor<Integer> {
	private final NoCastingRuleSet noCastingRules;
	private final CasterTable casterTable;
	private final DBTypeTable dbTypeMapping;

	public IntLabeledMappingHandlerExtractor(
			NoCastingRuleSet noCastingRules, CasterTable casterTable,
			DBTypeTable dbTypeMapping) {
		this.noCastingRules = noCastingRules;
		this.casterTable = casterTable;
		this.dbTypeMapping = dbTypeMapping;
	}

	@Override
	public List<MappingHandler> extract(List<ColumnMapping<Integer>> columnMappings, ResultSet resultSet) throws SQLException {
		ResultSetMetaData metadata = resultSet.getMetaData();
		List<MappingHandler> handlers = new ArrayList<MappingHandler>();
		for(ColumnMapping<Integer> mapping : columnMappings){
			int columnType = metadata.getColumnType(mapping.getLabel());
			Class<?> sourceType = dbTypeMapping.lookUp(columnType);
			Class<?> targetType = mapping.getFieldType();
			if(noCastingRules.noCastCheck(sourceType, targetType)){
				handlers.add(new MappingHandler(mapping.getLabel(), mapping.getFieldAccessor(), mapping.getFieldType(), null));
			}else{
				CastHandler caster = casterTable.getCaster(sourceType, targetType);
				handlers.add(new MappingHandler(mapping.getLabel(), mapping.getFieldAccessor(), mapping.getFieldType(), caster));
			}
		}
		return handlers;
	}

}
