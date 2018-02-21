/**
 *
 */
package info.san.gs.app.ddd.event.product;

import java.math.BigDecimal;

import org.axonframework.serialization.Revision;

import info.san.gs.app.ddd.command.product.ProductUpdateCommand;

/**
 * A product is updated.
 *
 * @author sangelloz-nicoud
 */
@Revision("1.0")
public class ProductUpdatedEvent {

	private final String id;

	private final String name;

	private final String description;

	private final String ean13;

	private final BigDecimal stockQty;

	private final BigDecimal minStockQty;

	private final BigDecimal targetStockQty;

	/**
	 * Default constructor.
	 *
	 * @param cmd the command the event is built from.
	 */
	public ProductUpdatedEvent(final ProductUpdateCommand cmd) {
		this.id = cmd.getId();
		this.name = cmd.getName();
		this.description = cmd.getDescription();
		this.ean13 = cmd.getEan13();
		this.stockQty = cmd.getStockQty();
		this.minStockQty = cmd.getMinStockQty();
		this.targetStockQty = cmd.getTargetStockQty();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the ean13
	 */
	public String getEan13() {
		return ean13;
	}

	/**
	 * @return the stockQty
	 */
	public BigDecimal getStockQty() {
		return stockQty;
	}

	/**
	 * @return the minStockQty
	 */
	public BigDecimal getMinStockQty() {
		return minStockQty;
	}

	/**
	 * @return the targetStockQty
	 */
	public BigDecimal getTargetStockQty() {
		return targetStockQty;
	}

}
