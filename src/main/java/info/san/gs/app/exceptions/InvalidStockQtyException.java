/**
 *
 */
package info.san.gs.app.exceptions;

/**
 * @author sangelloz-nicoud
 *
 */
public class InvalidStockQtyException extends RuntimeException {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 4391025295853625750L;

	/**
	 *
	 */
	public InvalidStockQtyException() {
		super();
	}

	/**
	 * @param message
	 */
	public InvalidStockQtyException(final String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidStockQtyException(final Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidStockQtyException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidStockQtyException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
