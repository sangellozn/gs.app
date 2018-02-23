/**
 *
 */
package info.san.gs.app.rest.exceptions.mapper;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import info.san.gs.app.rest.dto.ErrorDto;

/**
 * @author sangelloz-nicoud
 *
 */
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

	@Override
	public Response toResponse(final ValidationException exception) {
		return Response.status(Status.BAD_REQUEST).entity(new ErrorDto(Status.BAD_REQUEST.getStatusCode(), exception.getMessage())).build();
	}

}
