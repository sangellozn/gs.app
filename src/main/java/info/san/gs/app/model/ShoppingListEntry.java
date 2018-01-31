/**
 *
 */
package info.san.gs.app.model;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListEntry extends AbstractEntry {

	private String comment;

	private ShoppingListStateEnum state;

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

}
