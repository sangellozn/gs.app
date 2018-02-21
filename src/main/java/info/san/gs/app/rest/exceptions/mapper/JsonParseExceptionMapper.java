/**
 *
 */
package info.san.gs.app.rest.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.fasterxml.jackson.core.JsonParseException;

import info.san.gs.app.rest.dto.ErrorDto;

/**
 * Exception mapper for json parsing errors.
 *
 * @author sangelloz-nicoud
 *
 */
public class JsonParseExceptionMapper implements ExceptionMapper<JsonParseException> {

	@Override
	public Response toResponse(final JsonParseException exception) {
		return Response.status(Status.BAD_REQUEST).entity(new ErrorDto(Status.BAD_REQUEST.getStatusCode(), exception.getMessage())).build();
	}

}
