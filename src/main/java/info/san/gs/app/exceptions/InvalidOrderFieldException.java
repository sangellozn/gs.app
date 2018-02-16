/**
 *
 */
package info.san.gs.app.exceptions;

/**
 * @author sangelloz-nicoud
 *
 */
public class InvalidOrderFieldException extends RuntimeException {

	/**
	 *
	 */
	public InvalidOrderFieldException() {
		super();
	}

	/**
	 * @param message
	 */
	public InvalidOrderFieldException(final String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidOrderFieldException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidOrderFieldException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidOrderFieldException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
