/**
 *
 */
package info.san.gs.app.query;

import java.util.Collection;

import info.san.gs.app.model.Entry;

/**
 * @author sangelloz-nicoud
 *
 *
 * @param <E> Entry type.
 */
public interface QueryRepository<E extends Entry> {

	E get(String id);

	Collection<E> getAll(long page, long limit, String order);

	/**
	 * Query the total count of all objects.
	 *
	 * @return the total count.
	 */
	long count();

}
