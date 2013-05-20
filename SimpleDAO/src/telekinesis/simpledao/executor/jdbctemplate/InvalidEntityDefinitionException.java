package telekinesis.simpledao.executor.jdbctemplate;

public class InvalidEntityDefinitionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6691944477064507724L;

	private final Class<?> type;
	private final Exception nestedException;

	public InvalidEntityDefinitionException(Class<?> type,
			Exception nestedException) {
		super();
		this.type = type;
		this.nestedException = nestedException;
	}

	@Override
	public String toString() {
		return "InvalidEntityDefinitionException [type=" + type
				+ ", nestedException=" + nestedException + "]";
	}

}
