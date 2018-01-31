/**
 *
 */
package info.san.gs.app.exceptions;

/**
 * @author sangelloz-nicoud
 *
 */
public class ObjectNotFoundException extends RuntimeException {

	public ObjectNotFoundException(final Class<?> clazz, final Object id) {
		super("Object [type=" + clazz.getName() + "] with [id=" + id + "] is not found.");
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
