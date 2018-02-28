package info.san.gs.app.rest.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import info.san.gs.app.model.ShoppingListEntry;
import info.san.gs.app.rest.dto.shoppinglist.ShoppingListDto;

@Mapper(uses = {
		ShoppingListItemMapper.class
})
public interface ShoppingListMapper {

	ShoppingListMapper INSTANCE = Mappers.getMapper(ShoppingListMapper.class);

	ShoppingListDto shoppingListEntryToShoppingListDto(ShoppingListEntry entry);

}
