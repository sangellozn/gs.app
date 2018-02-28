/**
 *
 */
package info.san.gs.app.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListEntry extends AbstractEntry {

	private String comment;

	private ShoppingListStateEnum state;

	private Collection<ShoppingListItemEntry> items;

	/**
	 * Default constructor.
	 */
	public ShoppingListEntry() {
		super();
		this.items = new ArrayList<>();
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(final String comment) {
		this.comment = comment;
	}

	/**
	 * @return the state
	 */
	public ShoppingListStateEnum getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(final ShoppingListStateEnum state) {
		this.state = state;
	}

	/**
	 * @return the items
	 */
	public Collection<ShoppingListItemEntry> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(final Collection<ShoppingListItemEntry> items) {
		this.items = items;
	}

}
