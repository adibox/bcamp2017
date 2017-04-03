package curs.exceptions;

public class ValidationException extends Exception {
	public ValidationException(String pMsg) {
		super(pMsg);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}
