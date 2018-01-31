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
 *
 */
public interface Webservices<D, P> {

	P getAll(Long page, Long limit, String order);

	D get(String id);

	Response create(D obj);

	void update(D obj);

	void delete(Object id);

	Long count();

}
