/**
 *
 */
package info.san.gs.app.rest.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import info.san.gs.app.exceptions.InvalidStockQtyException;
import info.san.gs.app.rest.dto.ErrorDto;

/**
 * @author sangelloz-nicoud
 *
 */
public class InvalidStockQtyExceptionMapper implements ExceptionMapper<InvalidStockQtyException> {

	@Override
	public Response toResponse(final InvalidStockQtyException exception) {
		return Response.status(Status.BAD_REQUEST).entity(new ErrorDto(Status.BAD_REQUEST.getStatusCode(), exception.getMessage())).build();
	}

}
