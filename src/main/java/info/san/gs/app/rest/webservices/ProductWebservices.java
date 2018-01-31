package info.san.gs.app.rest.webservices;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import info.san.gs.app.ddd.command.product.ProductCreateCommand;
import info.san.gs.app.model.ProductEntry;
import info.san.gs.app.query.product.ProductQueryRepository;
import info.san.gs.app.query.product.ProductQueryRepositoryImpl;
import info.san.gs.app.rest.dto.mapper.ProductMapper;
import info.san.gs.app.rest.dto.product.ProductDto;
import info.san.gs.app.rest.dto.product.ProductPageDto;

/**
 * Webservices for product entity.
 *
 * @author sangelloz-nicoud
 *
 */
@Consumes(value = { MediaType.APPLICATION_JSON })
@Produces(value = { MediaType.APPLICATION_JSON })
@Path("products")
public class ProductWebservices extends AbstractWebservices<ProductDto, ProductPageDto> {

	private final ProductQueryRepository productQueryRepository = new ProductQueryRepositoryImpl();

	@Override
	public ProductPageDto getAll(final Long page, final Long limit, final String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("{id}")
	@Override
	public ProductDto get(@PathParam("id") final String id) {
		final ProductEntry productEntry = productQueryRepository.get(id);
		return ProductMapper.INSTANCE.productEntryToProductDto(productEntry);
	}

	@Override
	public Response create(final ProductDto obj) {
		final ProductCreateCommand cmd = new ProductCreateCommand.Builder().fromDto(obj);
		this.getCommandGateway().sendAndWait(cmd);
		return Response.created(URI.create("products/" + cmd.getId())).build();
	}

	@Override
	public void update(final ProductDto obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(final Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}



}
