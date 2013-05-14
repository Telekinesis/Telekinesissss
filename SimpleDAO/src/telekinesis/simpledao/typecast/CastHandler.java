package telekinesis.simpledao.typecast;

import java.lang.reflect.Method;

public class CastHandler {
	private final Object casterObject;
	private final Method castMethod;

	public CastHandler(Object casterObject, Method castMethod) {
		this.casterObject = casterObject;
		this.castMethod = castMethod;
	}
	
	public Object cast(Object inputValue){
		try {
			return castMethod.invoke(casterObject, inputValue);
		} catch (Exception e) {
			throw new InvalidCasterDefinitionException(e);
		}
	}

	@Override
	public String toString() {
		return "CastHandler [casterObject=" + casterObject + ", castMethod="
				+ castMethod + "]";
	}

}
