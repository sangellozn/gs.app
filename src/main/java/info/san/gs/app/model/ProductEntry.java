/**
 * 
 */
package info.san.gs.app.model;

import java.math.BigDecimal;

/**
 * @author sangelloz-nicoud
 *
 */
public class ProductEntry extends AbstractEntry {
	
	private String id;
	
	private String name;
	
	private String description;
	
	private String ean13;
	
	private BigDecimal stockQty;
	
	private BigDecimal minStockQty;
	
	private BigDecimal targetStockQty;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the ean13
	 */
	public String getEan13() {
		return ean13;
	}

	/**
	 * @param ean13 the ean13 to set
	 */
	public void setEan13(String ean13) {
		this.ean13 = ean13;
	}

	/**
	 * @return the stockQty
	 */
	public BigDecimal getStockQty() {
		return stockQty;
	}

	/**
	 * @param stockQty the stockQty to set
	 */
	public void setStockQty(BigDecimal stockQty) {
		this.stockQty = stockQty;
	}

	/**
	 * @return the minStockQty
	 */
	public BigDecimal getMinStockQty() {
		return minStockQty;
	}

	/**
	 * @param minStockQty the minStockQty to set
	 */
	public void setMinStockQty(BigDecimal minStockQty) {
		this.minStockQty = minStockQty;
	}

	/**
	 * @return the targetStockQty
	 */
	public BigDecimal getTargetStockQty() {
		return targetStockQty;
	}

	/**
	 * @param targetStockQty the targetStockQty to set
	 */
	public void setTargetStockQty(BigDecimal targetStockQty) {
		this.targetStockQty = targetStockQty;
	}
	
}
