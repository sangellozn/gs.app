package info.san.gs.app.rest.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import info.san.gs.app.model.ShoppingListItemEntry;
import info.san.gs.app.rest.dto.shoppinglist.ShoppingListItemDto;

@Mapper
public interface ShoppingListItemMapper {

	ShoppingListItemMapper INSTANCE = Mappers.getMapper(ShoppingListItemMapper.class);

	@Mappings({
		@Mapping(source = "product.name", target = "productName"),
		@Mapping(source = "product.ean13", target = "productEan13"),
	})
	ShoppingListItemDto shoppingListItemEntryToShoppingListItemDto(ShoppingListItemEntry entry);

}
