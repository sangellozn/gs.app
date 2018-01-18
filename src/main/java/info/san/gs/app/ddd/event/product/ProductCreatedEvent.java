/**
 *
 */
package info.san.gs.app.ddd.event.product;

import java.math.BigDecimal;

import org.axonframework.serialization.Revision;

import info.san.gs.app.ddd.command.product.ProductCreateCommand;

/**
 * A product is created.
 *
 * @author sangelloz-nicoud
 */
@Revision("1.0")
public class ProductCreatedEvent {

	private String id;

	private String name;

	private String description;

	private String ean13;

	private BigDecimal stockQty;

	private BigDecimal minStockQty;

	private BigDecimal targetStockQty;

	protected ProductCreatedEvent() {
		// Nothing.
	}

	public ProductCreatedEvent(final ProductCreateCommand cmd) {
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
