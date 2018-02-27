/**
 *
 */
package info.san.gs.app.rest.dto.shoppinglist;

import java.math.BigDecimal;

import info.san.gs.app.rest.dto.AbstractDto;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListItemDto extends AbstractDto {

	private BigDecimal qty;

	private String productId;

	private String productName;

	private String productEan13;

	@Override
	protected String getPath() {
		// N/A
		return null;
	}

	/**
	 * @return the qty
	 */
	public BigDecimal getQty() {
		return qty;
	}

	/**
	 * @param qty the qty to set
	 */
	public void setQty(final BigDecimal qty) {
		this.qty = qty;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(final String productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(final String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productEan13
	 */
	public String getProductEan13() {
		return productEan13;
	}

	/**
	 * @param productEan13 the productEan13 to set
	 */
	public void setProductEan13(final String productEan13) {
		this.productEan13 = productEan13;
	}

}
