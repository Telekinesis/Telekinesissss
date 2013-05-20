package telekinesis.simpledao.test.caster.noncasting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoCastingForNumericUpgrading implements NoCastingRule {
	private static Set<Class<?>> types = new HashSet<Class<?>>();
	private static Map<Class<?>, Integer> scoring = new HashMap<Class<?>, Integer>();

	@Override
	public boolean isCastNotNeeded(Class<?> inputType, Class<?> parameterType) {
		if(!types.contains(inputType) || !types.contains(parameterType))
			return false;
		if(!parameterType.isPrimitive())
			return false;
		int inputScore = scoring.get(inputType);
		int parameterScore = scoring.get(parameterType);
		return inputScore < parameterScore;
	}
	
	static{
		registerType(byte.class, 1);
		registerType(Byte.class, 1);
		registerType(short.class, 2);
		registerType(Short.class, 2);
		registerType(int.class, 3);
		registerType(Integer.class, 3);
		registerType(float.class, 4);
		registerType(Float.class, 4);
		registerType(long.class, 4);
		registerType(Long.class, 4);
		registerType(double.class, 5);
		registerType(Double.class, 5);
	}
	
	private static void registerType(Class<?> type, int score){
		types.add(type);
		scoring.put(type, score);
	}

}
