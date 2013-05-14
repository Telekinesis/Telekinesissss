package telekinesis.simpledao.typecast.dbtype;

public class InvalidDBTypeCodeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2536928985446917085L;
	private final int enteredCode;

	public InvalidDBTypeCodeException(int enteredCode) {
		super();
		this.enteredCode = enteredCode;
	}

	@Override
	public String toString() {
		return "InvalidDBTypeCodeException [enteredCode=" + enteredCode + "]";
	};
	
	
}
