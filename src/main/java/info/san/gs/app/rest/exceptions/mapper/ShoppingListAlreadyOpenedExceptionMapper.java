/**
 *
 */
package info.san.gs.app.rest.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import info.san.gs.app.exceptions.ShoppingListAlreadyOpenedException;
import info.san.gs.app.rest.dto.ErrorDto;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListAlreadyOpenedExceptionMapper implements ExceptionMapper<ShoppingListAlreadyOpenedException> {

	@Override
	public Response toResponse(final ShoppingListAlreadyOpenedException exception) {
		return Response.status(Status.CONFLICT).entity(new ErrorDto(Status.CONFLICT.getStatusCode(), exception.getMessage())).build();
	}

}
