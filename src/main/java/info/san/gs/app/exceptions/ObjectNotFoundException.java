/**
 *
 */
package info.san.gs.app.exceptions;

/**
 * @author sangelloz-nicoud
 *
 */
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -12905657201990793L;

	public ObjectNotFoundException(final Class<?> clazz, final Object id) {
		super("Object [type=" + clazz.getSimpleName() + "] with [id=" + id + "] is not found.");
	}

	public ObjectNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(final String message) {
		super(message);
	}

	public ObjectNotFoundException(final Throwable cause) {
		super(cause);
	}

}
