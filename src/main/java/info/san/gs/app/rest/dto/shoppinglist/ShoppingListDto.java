/**
 *
 */
package info.san.gs.app.rest.dto.shoppinglist;

import java.util.Collection;

import info.san.gs.app.model.ShoppingListStateEnum;
import info.san.gs.app.rest.dto.AbstractDto;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListDto extends AbstractDto {

	private String comment;

	private ShoppingListStateEnum state;

	private Collection<ShoppingListItemDto> items;

	@Override
	protected String getPath() {
		return "shoppinglist";
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
	 * @return the items
	 */
	public Collection<ShoppingListItemDto> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(final Collection<ShoppingListItemDto> items) {
		this.items = items;
	}

}
