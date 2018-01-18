package info.san.gs.app.ddd.aggregate;

import java.util.Set;

import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateMember;

public class ShoppingListAggregate {

	@AggregateIdentifier
	private String id;

	@AggregateMember
	private Set<ShoppingListItemAggregate> shoppingListItems;

	protected ShoppingListAggregate() {
		// Nothing.
	}

}
