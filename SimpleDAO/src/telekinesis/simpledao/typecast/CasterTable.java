package telekinesis.simpledao.typecast;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import telekinesis.simpledao.mapping.mapper.methodfilter.MethodFilter;
import telekinesis.simpledao.util.MethodSelector;


public class CasterTable {
	private Map<CasterKey, CastHandler> casters = new HashMap<CasterKey, CastHandler>();
	
	public void registerCaster(Object caster){
		List<Method> castingMethods = MethodSelector.select(caster.getClass(), new MethodFilter() {
			
			@Override
			public boolean accept(Method m) {
				if(m.getParameterTypes().length != 1)
					return false;
				return m.isAnnotationPresent(CasterMethod.class);
			}
		});
		for(Method m : castingMethods){
			CastHandler handler = new CastHandler(caster, m);
			Class<?> sourceType = m.getParameterTypes()[0];
			Class<?> targetType = m.getReturnType();
			CasterKey key = new CasterKey(sourceType, targetType);
			casters.put(key, handler);
		}
	}
	
	public CastHandler getCaster(Class<?> sourceType, Class<?> targetType){
		CasterKey key = new CasterKey(sourceType, targetType);
		return casters.get(key);
	}
	
}
