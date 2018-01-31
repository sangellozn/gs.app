package info.san.gs.app.rest.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import info.san.gs.app.model.ProductEntry;
import info.san.gs.app.rest.dto.product.ProductDto;

@Mapper
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	ProductDto productEntryToProductDto(ProductEntry productEntry);

}
