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
import info.san.gs.app.ddd.command.product.ProductUpdateCommand;
import info.san.gs.app.ddd.event.product.ProductCreatedEvent;
import info.san.gs.app.ddd.event.product.ProductDeletedEvent;
import info.san.gs.app.ddd.event.product.ProductUpdatedEvent;

/**
 * Product aggregate.
 *
 * @author sangelloz-nicoud
 *
 */
public class ProductAggregate {

	@AggregateIdentifier
	private String id;

	protected ProductAggregate() {
		// Nothing.
	}

	/**
	 * Handle the create command.
	 *
	 * @param cmd the create command.
	 */
	@CommandHandler
	public ProductAggregate(final ProductCreateCommand cmd) {
		AggregateLifecycle.apply(new ProductCreatedEvent(cmd));
	}

	/**
	 * Handle the delete command.
	 *
	 * @param cmd the delete command.
	 */
	@CommandHandler
	public void delete(final ProductDeleteCommand cmd) {
		AggregateLifecycle.apply(new ProductDeletedEvent(cmd.getId()));
	}

	/**
	 * Handle the update command.
	 *
	 * @param cmd the update command.
	 */
	@CommandHandler
	public void update(final ProductUpdateCommand cmd) {
		AggregateLifecycle.apply(new ProductUpdatedEvent(cmd));
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
