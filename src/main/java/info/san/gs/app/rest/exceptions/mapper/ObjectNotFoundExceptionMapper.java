/**
 *
 */
package info.san.gs.app.rest.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import info.san.gs.app.exceptions.ObjectNotFoundException;
import info.san.gs.app.rest.dto.ErrorDto;

/**
 * @author sangelloz-nicoud
 *
 */
public class ObjectNotFoundExceptionMapper implements ExceptionMapper<ObjectNotFoundException> {

	@Override
	public Response toResponse(final ObjectNotFoundException exception) {
		return Response.status(Status.NOT_FOUND).entity(new ErrorDto(Status.NOT_FOUND.getStatusCode(), exception.getMessage())).build();
	}

}
