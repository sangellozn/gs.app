package info.san.gs.app.ddd.command.handler;

import org.axonframework.commandhandling.CommandHandler;

import info.san.gs.app.ddd.command.shoppinglist.ShoppingListCreateCommand;

/**
 * Command handler for shopping list.
 *
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListCommandHandler {

	@CommandHandler
	public void handle(final ShoppingListCreateCommand cmd) {

	}

}
