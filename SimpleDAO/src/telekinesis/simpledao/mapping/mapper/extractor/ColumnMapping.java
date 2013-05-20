package telekinesis.simpledao.mapping.mapper.extractor;

import java.lang.reflect.Method;

public class ColumnMapping<T> {
	private final T label;
	private final Method fieldAccessor;
	private final Class<?> fieldType;

	public ColumnMapping(T label, Method fieldAccessor,
			Class<?> fieldType) {
		this.label = label;
		this.fieldAccessor = fieldAccessor;
		this.fieldType = fieldType;
	}

	public Class<?> getFieldType() {
		return fieldType;
	}

	public T getLabel() {
		return label;
	}

	public Method getFieldAccessor() {
		return fieldAccessor;
	}

	@Override
	public String toString() {
		return "ColumnMapping [label=" + label + ", fieldAccessor="
				+ fieldAccessor + ", fieldType=" + fieldType + "]";
	}

}
