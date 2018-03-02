package info.san.gs.app.ddd.aggregate;

import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;

import info.san.gs.app.ddd.event.shoppinglist.ShoppingListClosedEvent;
import info.san.gs.app.ddd.event.shoppinglist.ShoppingListCreatedEvent;
import info.san.gs.app.model.ShoppingListEntry;

/**
 *
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListAggregate {

	@AggregateIdentifier
	private String id;

	protected ShoppingListAggregate() {
		// Nothing.
	}

	public ShoppingListAggregate(final ShoppingListEntry shoppingListEntry) {
		AggregateLifecycle.apply(new ShoppingListCreatedEvent(shoppingListEntry));
	}

	public void close() {
		AggregateLifecycle.apply(new ShoppingListClosedEvent(this.id));
	}

	@EventSourcingHandler
	protected void on(final ShoppingListCreatedEvent evt) {
		this.id = evt.getShoppingListEntry().getId();
	}

	@EventSourcingHandler
	protected void on(final ShoppingListClosedEvent evt) {
		AggregateLifecycle.markDeleted();
	}

}
