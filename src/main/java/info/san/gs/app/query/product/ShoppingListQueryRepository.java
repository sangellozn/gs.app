package info.san.gs.app.query.product;

import java.util.Optional;

import info.san.gs.app.model.ShoppingListEntry;

/**
 * Query repository for shopping list.
 *
 * @author sangelloz-nicoud
 *
 */
public interface ShoppingListQueryRepository {

	/**
	 * Get the currently opened shopping list.
	 *
	 * @return the currently openend shopping list if any.
	 */
	Optional<ShoppingListEntry> getCurrent();

	/**
	 * Check if an opened shopping list exists.
	 *
	 * @return {@code true} is a shopping list has an opened state, {@code false} sinon.
	 */
	boolean isOpenedExist();

}
