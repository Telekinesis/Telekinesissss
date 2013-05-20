package telekinesis.simpledao.test.caster.noncasting;

import java.util.HashMap;
import java.util.Map;

public class NoCastingBetweenBoxingType implements NoCastingRule{
	private static Map<Class<?>, Class<?>> validTypePairs = new HashMap<Class<?>, Class<?>>();
	
	@Override
	public boolean isCastNotNeeded(Class<?> inputType, Class<?> parameterType) {
		return inputType.equals(validTypePairs.get(parameterType));
	}
	
	static {
		putBoxingPair(byte.class, Byte.class);
		putBoxingPair(short.class, Short.class);
		putBoxingPair(int.class, Integer.class);
		putBoxingPair(long.class, Long.class);
		putBoxingPair(float.class, Float.class);
		putBoxingPair(double.class, Double.class);
		putBoxingPair(char.class, Character.class);
		putBoxingPair(boolean.class, Boolean.class);
	}
	
	private static void putBoxingPair(Class<?> primitiveType, Class<?> boxingType){
		validTypePairs.put(primitiveType, boxingType);
		validTypePairs.put(boxingType, primitiveType);
	}
	
}
