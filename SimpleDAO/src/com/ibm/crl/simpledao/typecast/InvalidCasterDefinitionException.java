package com.ibm.crl.simpledao.typecast;

public class InvalidCasterDefinitionException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2914321000117555949L;
	private Exception nestedException;

	public InvalidCasterDefinitionException(Exception nestedException) {
		super();
		this.nestedException = nestedException;
	}
	
	public String toString(){
		return nestedException.toString();
	}
}
