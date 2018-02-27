package info.san.gs.app.ddd.aggregate;

import org.axonframework.commandhandling.model.AggregateIdentifier;

import info.san.gs.app.model.ShoppingListStateEnum;

public class ShoppingListAggregate {

	@AggregateIdentifier
	private String id;

	private ShoppingListStateEnum state;

	protected ShoppingListAggregate() {
		// Nothing.
	}




}
