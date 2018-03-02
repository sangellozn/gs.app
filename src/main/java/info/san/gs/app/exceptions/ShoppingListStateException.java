/**
 *
 */
package info.san.gs.app.exceptions;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListStateException extends RuntimeException {

	private static final long serialVersionUID = 2767417562529260996L;

	/**
	 *
	 */
	public ShoppingListStateException() {
		super();
	}

	/**
	 * @param message
	 */
	public ShoppingListStateException(final String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ShoppingListStateException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ShoppingListStateException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ShoppingListStateException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
