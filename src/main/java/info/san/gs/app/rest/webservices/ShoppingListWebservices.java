package info.san.gs.app.rest.webservices;

import javax.ws.rs.core.Response;

import info.san.gs.app.rest.dto.SimpleValueDto;
import info.san.gs.app.rest.dto.shoppinglist.ShoppingListDto;

/**
 * Webservices related to shopping list.
 *
 * @author sangelloz-nicoud
 *
 */
public interface ShoppingListWebservices {

	/**
	 * Ask for the computation of the next shopping list.
	 *
	 * @param comment a comment for the shopping list.
	 *
	 * @return the rest response.
	 */
	Response computeShoppingList(SimpleValueDto<String> comment);

	/**
	 * Close the current shopping list (if there is one).
	 */
	void closeCurrentShoppingList();

	/**
	 * Get the opened shopping list (if any).
	 *
	 * @return the current shopping list (state = 'OPENED').
	 */
	ShoppingListDto getCurrent();

}
