/**
 *
 */
package info.san.gs.app.ddd.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;

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
		AggregateLifecycle.apply(new ProductCreatedEvent(cmd));
	}

	protected ProductAggregate() {
		// Nothing.
	}

	@EventSourcingHandler
	protected void on(final ProductCreatedEvent evt) {
		this.id = evt.getId();
	}

}
