/**
 *
 */
package info.san.gs.app.rest.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import info.san.gs.app.exceptions.ShoppingListStateException;
import info.san.gs.app.rest.dto.ErrorDto;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListStateExceptionMapper implements ExceptionMapper<ShoppingListStateException> {

	@Override
	public Response toResponse(final ShoppingListStateException exception) {
		return Response.status(Status.CONFLICT).entity(new ErrorDto(Status.CONFLICT.getStatusCode(), exception.getMessage())).build();
	}

}
