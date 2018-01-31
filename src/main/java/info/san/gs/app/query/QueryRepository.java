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

	E get(Object id);

	Collection<E> getAll(Long page, Long limit, String order);

}
