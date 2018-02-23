/**
 *
 */
package info.san.gs.app.ddd.event.product;

import java.math.BigDecimal;

/**
 * Event when stock qantity is remove to a product.
 *
 * @author sangelloz-nicoud
 *
 */
public class ProductStockRemoveEvent {

	private final String id;

	private final BigDecimal qty;

	/**
	 * Default constructor.
	 *
	 * @param id product identifier.
	 * @param qty quantity to remove from stock.
	 */
	public ProductStockRemoveEvent(final String id, final BigDecimal qty) {
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
