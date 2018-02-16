/**
 *
 */
package info.san.gs.app.ddd.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;

import info.san.gs.app.ddd.command.product.ProductCreateCommand;
import info.san.gs.app.ddd.command.product.ProductDeleteCommand;
import info.san.gs.app.ddd.event.product.ProductCreatedEvent;
import info.san.gs.app.ddd.event.product.ProductDeletedEvent;

/**
 * @author sangelloz-nicoud
 *
 */
public class ProductAggregate {

	@AggregateIdentifier
	private String id;

	protected ProductAggregate() {
		// Nothing.
	}

	@CommandHandler
	public ProductAggregate(final ProductCreateCommand cmd) {
		AggregateLifecycle.apply(new ProductCreatedEvent(cmd));
	}

	@CommandHandler
	public void delete(final ProductDeleteCommand cmd) {
		AggregateLifecycle.apply(new ProductDeletedEvent(cmd.getId()));
	}

	@EventSourcingHandler
	protected void on(final ProductCreatedEvent evt) {
		this.id = evt.getId();
	}

	@EventSourcingHandler
	protected void on(@SuppressWarnings("unused") final ProductDeletedEvent evt) {
		AggregateLifecycle.markDeleted();
	}

}
