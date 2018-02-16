/**
 *
 */
package info.san.gs.app.rest.webservices;

import javax.ws.rs.core.Response;

/**
 * Webservices interface.
 *
 * @author sangelloz-nicoud
 *
 * @param <D> the DTO type.
 * @param <P> the page DTO type.
 */
public interface Webservices<D, P> {

	P getAll(long page, long limit, String order);

	D get(String id);

	Response create(D obj);

	void update(String id, D obj);

	/**
	 * Delete an item by its identifier.
	 *
	 * @param id the item identifier to delete.
	 */
	void delete(String id);

	/**
	 * Count all items.
	 *
	 * @return the total count of items.
	 */
	long count();

}
