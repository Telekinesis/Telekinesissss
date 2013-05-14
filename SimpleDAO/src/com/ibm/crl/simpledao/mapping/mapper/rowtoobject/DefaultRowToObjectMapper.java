package com.ibm.crl.simpledao.mapping.mapper.rowtoobject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.crl.simpledao.executor.jdbctemplate.InvalidEntityDefinitionException;
import com.ibm.crl.simpledao.reflection.BeanCreator;

public class DefaultRowToObjectMapper<T> implements RowToObjectMapper<T> {
	private final List<MappingHandler> mappingHandlers;
	private final Class<T> targetType;

	public DefaultRowToObjectMapper(List<MappingHandler> mappingHandlers,
			Class<T> targetType) {
		this.mappingHandlers = mappingHandlers;
		this.targetType = targetType;
	}

	@Override
	public List<T> mapToObjects(ResultSet result) throws SQLException {
		List<T> objects = new ArrayList<T>();
		while(result.next()){
			T newBean = BeanCreator.createBean(targetType);
			for(MappingHandler handler : mappingHandlers){
				Object sourceValue = result.getObject(handler.label);
				try {
					if(handler.caster != null && sourceValue != null)
						sourceValue = handler.caster.cast(sourceValue);
					handler.fieldAccessor.invoke(newBean, sourceValue);
				} catch (Exception e) {
					throw new InvalidEntityDefinitionException(targetType, e);
				}
			}
			objects.add(newBean);
		}
		return objects;
	}
	
}
