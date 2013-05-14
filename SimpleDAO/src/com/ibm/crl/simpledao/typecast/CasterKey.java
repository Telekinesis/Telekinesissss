package com.ibm.crl.simpledao.typecast;

class CasterKey {
	private final Class<?> sourceType;
	private final Class<?> targetType;

	public CasterKey(Class<?> sourceType, Class<?> targetType) {
		this.sourceType = sourceType;
		this.targetType = targetType;
	}

	public Class<?> getSourceType() {
		return sourceType;
	}

	public Class<?> getTargetType() {
		return targetType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sourceType == null) ? 0 : sourceType.hashCode());
		result = prime * result
				+ ((targetType == null) ? 0 : targetType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CasterKey other = (CasterKey) obj;
		if (sourceType == null) {
			if (other.sourceType != null)
				return false;
		} else if (!sourceType.equals(other.sourceType))
			return false;
		if (targetType == null) {
			if (other.targetType != null)
				return false;
		} else if (!targetType.equals(other.targetType))
			return false;
		return true;
	}

}
