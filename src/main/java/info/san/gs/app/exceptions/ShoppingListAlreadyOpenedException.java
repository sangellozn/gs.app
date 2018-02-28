/**
 *
 */
package info.san.gs.app.exceptions;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListAlreadyOpenedException extends RuntimeException {

	private static final long serialVersionUID = 2767417562529260996L;

	/**
	 *
	 */
	public ShoppingListAlreadyOpenedException() {
		super();
	}

	/**
	 * @param message
	 */
	public ShoppingListAlreadyOpenedException(final String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ShoppingListAlreadyOpenedException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ShoppingListAlreadyOpenedException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ShoppingListAlreadyOpenedException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
