/**
 *
 */
package info.san.gs.app.ddd.aggregate;

import java.io.Serializable;
import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;

import info.san.gs.app.ddd.command.product.ProductCommandValidatorHelper;
import info.san.gs.app.ddd.command.product.ProductCreateCommand;
import info.san.gs.app.ddd.command.product.ProductDeleteCommand;
import info.san.gs.app.ddd.command.product.ProductStockRemoveCommand;
import info.san.gs.app.ddd.command.product.ProductUpdateCommand;
import info.san.gs.app.ddd.event.product.ProductCreatedEvent;
import info.san.gs.app.ddd.event.product.ProductDeletedEvent;
import info.san.gs.app.ddd.event.product.ProductStockRemoveEvent;
import info.san.gs.app.ddd.event.product.ProductUpdatedEvent;
import info.san.gs.app.exceptions.InvalidStockQtyException;

/**
 * Product aggregate.
 *
 * @author sangelloz-nicoud
 *
 */
public class ProductAggregate implements Serializable {

	private static final long serialVersionUID = -1338844177063408265L;

	@AggregateIdentifier
	private String id;

	private BigDecimal stockQty;

	protected ProductAggregate() {
		// Nothing.
	}

	/**
	 * Handle the create command.
	 *
	 * @param cmd the create command.
	 */
	@CommandHandler
	public ProductAggregate(final ProductCreateCommand cmd) {
		ProductCommandValidatorHelper.validateWriteCommand(cmd);
		AggregateLifecycle.apply(new ProductCreatedEvent(cmd));
	}

	/**
	 * Handle the delete command.
	 *
	 * @param cmd the delete command.
	 */
	@CommandHandler
	public void delete(final ProductDeleteCommand cmd) {
		AggregateLifecycle.apply(new ProductDeletedEvent(cmd.getId()));
	}

	/**
	 * Handle the update command.
	 *
	 * @param cmd the update command.
	 */
	@CommandHandler
	public void update(final ProductUpdateCommand cmd) {
		ProductCommandValidatorHelper.validateWriteCommand(cmd);
		AggregateLifecycle.apply(new ProductUpdatedEvent(cmd));
	}

	/**
	 * Remove a stock quantity to the actual product stock.
	 *
	 * @param cmd the remove stock command.
	 */
	@CommandHandler
	public void removeQty(final ProductStockRemoveCommand cmd) {
		ProductCommandValidatorHelper.validateStockRemoveCommand(cmd);

		// Cannot remove stock that we don't have.
		if (cmd.getQty().compareTo(stockQty) > 0) {
			throw new InvalidStockQtyException("There isn't not enought stock [actual=" + this.stockQty.toPlainString()
			+ "]. Cannot remove [qty=" + cmd.getQty().toPlainString() + "].");
		}

		AggregateLifecycle.apply(new ProductStockRemoveEvent(cmd.getId(), cmd.getQty()));
	}

	@EventSourcingHandler
	protected void on(final ProductCreatedEvent evt) {
		this.id = evt.getId();
		this.stockQty = evt.getStockQty();
	}

	@EventSourcingHandler
	protected void on(@SuppressWarnings("unused") final ProductDeletedEvent evt) {
		AggregateLifecycle.markDeleted();
	}

	@EventSourcingHandler
	protected void on(final ProductStockRemoveEvent evt) {
		this.stockQty = this.stockQty.subtract(evt.getQty());
	}

	@EventSourcingHandler
	protected void on(final ProductUpdatedEvent evt) {
		this.stockQty = evt.getStockQty();
	}

}
