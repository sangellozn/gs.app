/**
 *
 */
package info.san.gs.app.query.product;

import java.util.Optional;

import org.jdbi.v3.core.locator.ClasspathSqlLocator;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;

import info.san.gs.app.JdbiConnector;
import info.san.gs.app.model.ProductEntry;
import info.san.gs.app.model.ShoppingListEntry;
import info.san.gs.app.model.ShoppingListItemEntry;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListQueryRepositoryImpl implements ShoppingListQueryRepository {

	@Override
	public Optional<ShoppingListEntry> getCurrent() {
		return JdbiConnector.getJdbi().withHandle(h ->
				h.createQuery(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.shoppinglist.getCurrent"))
						.registerRowMapper(BeanMapper.factory(ShoppingListEntry.class, "sl_"))
						.registerRowMapper(BeanMapper.factory(ShoppingListItemEntry.class, "sli_"))
						.registerRowMapper(BeanMapper.factory(ProductEntry.class, "p_"))
						.reduceRows(Optional.<ShoppingListEntry>empty(), (acc, rowView) -> {
								final ShoppingListEntry sl = acc.orElseGet(() -> rowView.getRow(ShoppingListEntry.class));

								final ShoppingListItemEntry sli = rowView.getRow(ShoppingListItemEntry.class);
								sli.setProduct(rowView.getRow(ProductEntry.class));

								sl.getItems().add(sli);

								return Optional.of(sl);
						})
		);
	}

	@Override
	public boolean isOpenedExist() {
		return JdbiConnector.getJdbi().withHandle(h ->
				h.createQuery(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.shoppinglist.isOpenedExist"))
						.map((rs, i, ctx) -> Boolean.valueOf(rs.getString(i)))
						.findOnly()
		);
	}

}
