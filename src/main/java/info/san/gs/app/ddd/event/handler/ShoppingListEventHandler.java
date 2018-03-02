/**
 *
 */
package info.san.gs.app.ddd.event.handler;

import org.axonframework.eventhandling.EventHandler;
import org.jdbi.v3.core.locator.ClasspathSqlLocator;

import info.san.gs.app.JdbiConnector;
import info.san.gs.app.ddd.event.shoppinglist.ShoppingListClosedEvent;
import info.san.gs.app.ddd.event.shoppinglist.ShoppingListCreatedEvent;

/**
 * Handle events on shopping list.
 *
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListEventHandler {

	@EventHandler
	public void on(final ShoppingListCreatedEvent evt) {
		JdbiConnector.getJdbi().useTransaction(h -> {
				h.createUpdate(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.shoppinglist.insert"))
						.bindBean(evt.getShoppingListEntry())
						.execute();

				evt.getShoppingListEntry().getItems().stream().forEach(item -> {
					h.createUpdate(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.shoppinglistitem.insert"))
						.bindBean(item)
						.bind("shoppingListId", evt.getShoppingListEntry().getId())
						.execute();
				});
		});
	}

	@EventHandler
	public void on(final ShoppingListClosedEvent evt) {
		JdbiConnector.getJdbi().withHandle(h ->
				h.createUpdate(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.shoppinglist.close"))
						.bind("id", evt.getId())
						.execute()
		);
	}

}
