package meubar.business.exceptions;

public class DBException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5690608998425795641L;
	private String message;

	public DBException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
