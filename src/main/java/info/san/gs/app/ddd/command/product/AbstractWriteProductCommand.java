/**
 *
 */
package info.san.gs.app.ddd.command.product;

import java.math.BigDecimal;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * @author sangelloz-nicoud
 *
 */
public class AbstractWriteProductCommand {

	@TargetAggregateIdentifier
	protected String id;

	protected String name;

	protected String description;

	protected String ean13;

	protected BigDecimal stockQty;

	protected BigDecimal minStockQty;

	protected BigDecimal targetStockQty;

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
