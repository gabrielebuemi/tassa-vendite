package it.asssetdata.test.tassa.exception;

public class TassaVenditeException extends Exception {

	private static final long serialVersionUID = 1168871967120902050L;

	public TassaVenditeException() {
		super();
	}

	public TassaVenditeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TassaVenditeException(String message, Throwable cause) {
		super(message, cause);
	}

	public TassaVenditeException(String message) {
		super(message);
	}

	public TassaVenditeException(Throwable cause) {
		super(cause);
	}

}
