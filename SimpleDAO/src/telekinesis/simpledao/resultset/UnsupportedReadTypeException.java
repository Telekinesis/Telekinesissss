package telekinesis.simpledao.resultset;

public class UnsupportedReadTypeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4203063398872991394L;
	
	private final int readType;

	public UnsupportedReadTypeException(int readType) {
		this.readType = readType;
	}

	@Override
	public String toString() {
		return "UnsupportedReadTypeException [readType=" + readType + "]";
	}

}
