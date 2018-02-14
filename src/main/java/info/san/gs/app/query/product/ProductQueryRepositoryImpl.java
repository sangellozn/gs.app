/**
 *
 */
package info.san.gs.app.query.product;

import java.util.Collection;

import org.jdbi.v3.core.locator.ClasspathSqlLocator;

import info.san.gs.app.JdbiConnector;
import info.san.gs.app.exceptions.ObjectNotFoundException;
import info.san.gs.app.model.ProductEntry;

/**
 * @author sangelloz-nicoud
 *
 */
public class ProductQueryRepositoryImpl implements ProductQueryRepository {

	@Override
	public ProductEntry get(final Object id) {
		return JdbiConnector.getJdbi().withHandle(h ->
				h.createQuery(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.product.get"))
				.bind("id", id)
				.mapTo(ProductEntry.class)
				.findFirst()
		).orElseThrow(() -> new ObjectNotFoundException(ProductEntry.class, id));
	}

	@Override
	public Collection<ProductEntry> getAll(final Long page, final Long limit, final String order) {
		// TODO Auto-generated method stub
		return null;
	}

}
