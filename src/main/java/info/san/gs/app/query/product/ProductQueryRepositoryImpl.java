/**
 *
 */
package info.san.gs.app.query.product;

import java.util.Collection;

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
				h.createQuery("Select id, name, description, ean13, stock_qty, min_stock_qty, "
						+ "target_stock_qty, created_at, updated_at, version, deleted "
						+ "From product where id = :id")
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
