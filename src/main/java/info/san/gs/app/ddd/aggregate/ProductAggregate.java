/**
 *
 */
package info.san.gs.app.ddd.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;

import info.san.gs.app.ddd.command.product.ProductCreateCommand;
import info.san.gs.app.ddd.event.product.ProductCreatedEvent;

/**
 * @author sangelloz-nicoud
 *
 */
public class ProductAggregate {

	@AggregateIdentifier
	private String id;

	@CommandHandler
	public ProductAggregate(final ProductCreateCommand cmd) {
		apply(new ProductCreatedEvent(cmd));
	}

	protected ProductAggregate() {
		// Nothing.
	}

}
