package com.ibm.crl.simpledao.reflection;

public class BeanCreationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5863689255428290109L;

	private final Exception enclosingException;

	public BeanCreationException(Exception enclosingException) {
		this.enclosingException = enclosingException;
	}

	@Override
	public String toString() {
		return "BeanCreationException [enclosingException="
				+ enclosingException + "]";
	}
	
}
