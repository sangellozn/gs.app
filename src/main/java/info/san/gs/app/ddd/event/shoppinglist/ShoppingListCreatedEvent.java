package info.san.gs.app.ddd.event.shoppinglist;

import org.axonframework.serialization.Revision;

import info.san.gs.app.model.ShoppingListEntry;

/**
 * A shopping list is created.
 *
 * @author sangelloz-nicoud
 *
 */
@Revision("1.0")
public class ShoppingListCreatedEvent {

	private final ShoppingListEntry shoppingListEntry;

	public ShoppingListCreatedEvent(final ShoppingListEntry shoppingListEntry) {
		this.shoppingListEntry = shoppingListEntry;
	}

	/**
	 * @return the shoppingListEntry
	 */
	public ShoppingListEntry getShoppingListEntry() {
		return shoppingListEntry;
	}

}
