/**
 * 
 */
package info.san.gs.app.model;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListEntry extends AbstractEntry {
	
	private String id;
	
	private String comment;
	
	private ShoppingListStateEnum state;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	public void setComment(String comment) {
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
	public void setState(ShoppingListStateEnum state) {
		this.state = state;
	}
	
}
