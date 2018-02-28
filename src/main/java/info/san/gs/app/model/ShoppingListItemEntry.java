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

	private String productId;

	private String shoppingListId;

	private BigDecimal qty;

	private ProductEntry product;

	private ShoppingListEntry shoppingList;

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
	 * @return the shoppingListId
	 */
	public String getShoppingListId() {
		return shoppingListId;
	}

	/**
	 * @param shoppingListId the shoppingListId to set
	 */
	public void setShoppingListId(final String shoppingListId) {
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
	public void setQty(final BigDecimal qty) {
		this.qty = qty;
	}

	/**
	 * @return the product
	 */
	public ProductEntry getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(final ProductEntry product) {
		this.product = product;
	}

	/**
	 * @return the shoppingList
	 */
	public ShoppingListEntry getShoppingList() {
		return shoppingList;
	}

	/**
	 * @param shoppingList the shoppingList to set
	 */
	public void setShoppingList(final ShoppingListEntry shoppingList) {
		this.shoppingList = shoppingList;
	}

}
