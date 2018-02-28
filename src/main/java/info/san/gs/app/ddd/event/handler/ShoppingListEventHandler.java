/**
 *
 */
package info.san.gs.app.ddd.event.handler;

import org.axonframework.eventhandling.EventHandler;

import info.san.gs.app.ddd.event.shoppinglist.ShoppingListCreatedEvent;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListEventHandler {

	@EventHandler
	public void on(final ShoppingListCreatedEvent evt) {

	}

}
