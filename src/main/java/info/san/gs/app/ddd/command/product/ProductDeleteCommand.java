package info.san.gs.app.ddd.command.product;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Delete a product.
 *
 * @author sangelloz-nicoud
 */
public class ProductDeleteCommand {

	@TargetAggregateIdentifier
	private final String id;

	/**
	 * Default constructor.
	 *
	 * @param id identifier for product to delete.
	 */
	public ProductDeleteCommand(final String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
