/**
 *
 */
package info.san.gs.app.query.product;

import java.util.Collection;
import java.util.stream.Collectors;

import org.jdbi.v3.core.locator.ClasspathSqlLocator;

import info.san.gs.app.JdbiConnector;
import info.san.gs.app.exceptions.ObjectNotFoundException;
import info.san.gs.app.model.ProductEntry;
import info.san.gs.app.query.OrderHelper;

/**
 * @author sangelloz-nicoud
 *
 */
public class ProductQueryRepositoryImpl implements ProductQueryRepository {

	@Override
	public ProductEntry get(final String id) {
		return JdbiConnector.getJdbi().withHandle(h ->
				h.createQuery(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.product.get"))
					.bind("id", id)
					.mapTo(ProductEntry.class)
					.findFirst()
		).orElseThrow(() -> new ObjectNotFoundException(ProductEntry.class, id));
	}

	@Override
	public Collection<ProductEntry> getAll(final long page, final long limit, final String order) {
		String sqlQuery = ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.product.getAll");

		if (order != null && !order.isEmpty()) {
			sqlQuery = sqlQuery.replace(OrderHelper.ORDER_BY_PLACEHOLDER, OrderHelper.parseOrder(order, ProductEntry.class));
		} else {
			sqlQuery = sqlQuery.replace(OrderHelper.ORDER_BY_PLACEHOLDER, "");
		}

		final String finalSqlQuery = sqlQuery;


		return JdbiConnector.getJdbi().withHandle(h ->
				h.createQuery(finalSqlQuery)
					.bind("count", limit)
					.bind("offset", limit * page)
					.mapTo(ProductEntry.class)
					.collect(Collectors.toList())
		);
	}

	@Override
	public long count() {
		return JdbiConnector.getJdbi().withHandle(h ->
				h.createQuery(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.product.count"))
					.mapTo(Long.class)
					.findOnly()
		);
	}

}
