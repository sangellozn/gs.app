package info.san.gs.app.rest.dto.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import info.san.gs.app.model.ProductEntry;
import info.san.gs.app.rest.dto.product.ProductDto;

/**
 * Mapper for product DTO and product entry.
 *
 * @author sangelloz-nicoud
 */
@Mapper
public interface ProductMapper {

	/**
	 * The mapper instance.
	 */
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	ProductDto productEntryToProductDto(ProductEntry productEntry);

	Collection<ProductDto> productEntryCollectionToProductDtoCollection(Collection<ProductEntry> data);

}
