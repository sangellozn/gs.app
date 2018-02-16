package info.san.gs.app.rest.webservices;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import info.san.gs.app.ddd.command.product.ProductCreateCommand;
import info.san.gs.app.ddd.command.product.ProductDeleteCommand;
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

	@GET
	@Override
	public ProductPageDto getAll(@QueryParam("p") @DefaultValue("0") final long page,
			@QueryParam("l") @DefaultValue("20") final long limit,
			@QueryParam("o") @DefaultValue("") final String order) {
		final Collection<ProductEntry> data = this.productQueryRepository.getAll(page, limit, order);
		return new ProductPageDto(ProductMapper.INSTANCE.productEntryCollectionToProductDtoCollection(data),
				this.productQueryRepository.count(),
				page, limit);
	}

	@GET
	@Path("{id}")
	@Override
	public ProductDto get(@PathParam("id") final String id) {
		final ProductEntry productEntry = productQueryRepository.get(id);
		return ProductMapper.INSTANCE.productEntryToProductDto(productEntry);
	}

	@POST
	@Override
	public Response create(final ProductDto obj) {
		final ProductCreateCommand cmd = new ProductCreateCommand.Builder().fromDto(obj);
		this.getCommandGateway().sendAndWait(cmd);
		return Response.created(URI.create("products/" + cmd.getId())).build();
	}

	@PUT
	@Path("{id}")
	@Override
	public void update(@PathParam("id") final String id, final ProductDto obj) {
		// TODO Auto-generated method stub

	}

	@DELETE
	@Path("{id}")
	@Override
	public void delete(@PathParam("id") final String id) {
		final ProductDeleteCommand cmd = new ProductDeleteCommand(id);
		this.getCommandGateway().sendAndWait(cmd);
	}

	@GET
	@Path("/count")
	@Override
	public long count() {
		return this.productQueryRepository.count();
	}



}
