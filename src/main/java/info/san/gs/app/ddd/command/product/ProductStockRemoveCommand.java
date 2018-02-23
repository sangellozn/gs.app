package info.san.gs.app.ddd.command.product;

import java.math.BigDecimal;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Command for consuming a product qantity from current stock.
 *
 * @author sangelloz-nicoud
 *
 */
public class ProductStockRemoveCommand {

	@TargetAggregateIdentifier
	private final String id;

	private final BigDecimal qty;

	/**
	 * Default constructor.
	 *
	 * @param id the product identifier.
	 * @param qty the quantity to remove.
	 */
	public ProductStockRemoveCommand(final String id, final BigDecimal qty) {
		this.id = id;
		this.qty = qty;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the qty
	 */
	public BigDecimal getQty() {
		return qty;
	}

}
