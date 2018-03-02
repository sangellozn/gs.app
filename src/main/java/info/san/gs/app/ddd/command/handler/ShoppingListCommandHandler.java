package info.san.gs.app.ddd.command.handler;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Repository;

import info.san.gs.app.ddd.aggregate.ShoppingListAggregate;
import info.san.gs.app.ddd.command.shoppinglist.ShoppingListCloseCommand;
import info.san.gs.app.ddd.command.shoppinglist.ShoppingListCreateCommand;
import info.san.gs.app.exceptions.ShoppingListHasNoItemException;
import info.san.gs.app.exceptions.ShoppingListStateException;
import info.san.gs.app.model.ShoppingListEntry;
import info.san.gs.app.model.ShoppingListItemEntry;
import info.san.gs.app.query.product.ProductQueryRepository;
import info.san.gs.app.query.product.ProductQueryRepositoryImpl;
import info.san.gs.app.query.product.ShoppingListQueryRepository;
import info.san.gs.app.query.product.ShoppingListQueryRepositoryImpl;

/**
 * Command handler for shopping list.
 *
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListCommandHandler {

	private final ShoppingListQueryRepository shoppingListQueryRepository = new ShoppingListQueryRepositoryImpl();

	private final ProductQueryRepository productQueryRepository = new ProductQueryRepositoryImpl();

	private final Repository<ShoppingListAggregate> repository;

	public ShoppingListCommandHandler(final Repository<ShoppingListAggregate> repository) {
		this.repository = repository;
	}

	@CommandHandler
	public void handle(final ShoppingListCreateCommand cmd) throws Exception {
		if (shoppingListQueryRepository.isOpenedExist()) {
			throw new ShoppingListStateException("A shopping list is already opened. Close the current one first.");
		}

		final Map<String, BigDecimal> toOrder = productQueryRepository.getProductQtyToOrder();

		if (toOrder.isEmpty()) {
			throw new ShoppingListHasNoItemException("No product to order");
		}

		final ShoppingListEntry slEntry = new ShoppingListEntry();
		slEntry.setComment(cmd.getComment());
		slEntry.setId(cmd.getId());

		toOrder.forEach((productId, qty) -> {
			final ShoppingListItemEntry sliEntry = new ShoppingListItemEntry();
			sliEntry.setId(UUID.randomUUID().toString());
			sliEntry.setProductId(productId);
			sliEntry.setQty(qty);

			slEntry.getItems().add(sliEntry);
		});

		repository.newInstance(() -> new ShoppingListAggregate(slEntry));
	}

	@CommandHandler
	public void handle(final ShoppingListCloseCommand cmd) {
		final Optional<String> currentSlId = shoppingListQueryRepository.getCurrentId();

		if (!currentSlId.isPresent()) {
			throw new ShoppingListStateException("There no opened shopping list. Create one first.");
		}

		final ShoppingListAggregate agg = (ShoppingListAggregate) repository.load(currentSlId.get());
		agg.close();
	}

}
