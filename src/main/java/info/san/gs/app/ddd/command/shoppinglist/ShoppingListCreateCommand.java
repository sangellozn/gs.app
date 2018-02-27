/**
 *
 */
package info.san.gs.app.ddd.command.shoppinglist;

import java.util.UUID;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Ask for the shopping list computation.
 *
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListCreateCommand {

	@TargetAggregateIdentifier
	private final String id;

	private final String comment;

	/**
	 * Default constructor.
	 *
	 * @param comment a comment for the shopping list (nullable).
	 */
	public ShoppingListCreateCommand(final String comment) {
		this.id = UUID.randomUUID().toString();
		this.comment = comment;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

}
