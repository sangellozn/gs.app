/**
 *
 */
package info.san.gs.app.ddd.event.shoppinglist;

import org.axonframework.serialization.Revision;

/**
 * The current shopping list is closed.
 *
 * @author sangelloz-nicoud
 *
 */
@Revision("1.0")
public class ShoppingListClosedEvent {

	private final String id;

	/**
	 * Default constructor.
	 *
	 * @param id the shopping list identifier.
	 */
	public ShoppingListClosedEvent(final String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
