package telekinesis.simpledao.mapping.mapper.methodfilter;

import java.lang.reflect.Method;

public class PrefixFilter implements MethodFilter {

	private final String prefix;

	public PrefixFilter(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public boolean accept(Method m) {
		String methodName = m.getName();
		return methodName.startsWith(prefix);
	}

}
