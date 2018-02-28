/**
 *
 */
package info.san.gs.app.exceptions;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListHasNoItemException extends RuntimeException {

	private static final long serialVersionUID = 2073137969906501220L;

	/**
	 *
	 */
	public ShoppingListHasNoItemException() {
		super();
	}

	/**
	 * @param message
	 */
	public ShoppingListHasNoItemException(final String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ShoppingListHasNoItemException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ShoppingListHasNoItemException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ShoppingListHasNoItemException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
