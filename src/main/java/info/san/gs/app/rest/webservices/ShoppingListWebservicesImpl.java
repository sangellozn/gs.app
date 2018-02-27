/**
 *
 */
package info.san.gs.app.rest.webservices;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import info.san.gs.app.ddd.command.shoppinglist.ShoppingListCreateCommand;
import info.san.gs.app.rest.dto.SimpleValueDto;
import info.san.gs.app.rest.dto.shoppinglist.ShoppingListDto;

/**
 * @author sangelloz-nicoud
 *
 */
@Path("shoppinglist")
public class ShoppingListWebservicesImpl extends AbstractWebservices implements ShoppingListWebservices {

	@POST
	@Path("create")
	@Override
	public Response computeShoppingList(final SimpleValueDto<String> comment) {
		final ShoppingListCreateCommand cmd = new ShoppingListCreateCommand(comment.getValue());
		this.getCommandGateway().sendAndWait(cmd);
		return Response.created(URI.create("shoppinglist/current")).build();
	}

	@POST
	@Path("close")
	@Override
	public void closeCurrentShoppingList() {
		// TODO Auto-generated method stub

	}

	@GET
	@Path("current")
	@Override
	public ShoppingListDto getCurrent() {
		// TODO Auto-generated method stub
		return null;
	}

}
