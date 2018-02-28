package info.san.gs.app.ddd.aggregate;

import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;

import info.san.gs.app.ddd.event.shoppinglist.ShoppingListCreatedEvent;
import info.san.gs.app.model.ShoppingListEntry;
import info.san.gs.app.model.ShoppingListStateEnum;

public class ShoppingListAggregate {

	@AggregateIdentifier
	private String id;

	private ShoppingListStateEnum state;

	protected ShoppingListAggregate() {
		// Nothing.
	}

	public ShoppingListAggregate(final ShoppingListEntry shoppingListEntry) {
		AggregateLifecycle.apply(new ShoppingListCreatedEvent(shoppingListEntry));
	}

	@EventSourcingHandler
	public void on(final ShoppingListCreatedEvent evt) {
		this.id = evt.getShoppingListEntry().getId();
		this.state = ShoppingListStateEnum.OPENED;
	}

}
