/**
 * 
 */
package info.san.gs.app.model;

import java.math.BigDecimal;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListItemEntry extends AbstractEntry {

	private String id;
	
	private String productId;
	
	private String shoppingListId;
	
	private BigDecimal qty;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the shoppingListId
	 */
	public String getShoppingListId() {
		return shoppingListId;
	}

	/**
	 * @param shoppingListId the shoppingListId to set
	 */
	public void setShoppingListId(String shoppingListId) {
		this.shoppingListId = shoppingListId;
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
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	
}
