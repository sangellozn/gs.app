/**
 *
 */
package info.san.gs.app.rest.dto.product;

import java.math.BigDecimal;

import info.san.gs.app.rest.dto.AbstractDto;

/**
 * DTO for product REST services.
 *
 * @author sangelloz-nicoud
 *
 */
public class ProductDto extends AbstractDto {

	private String name;

	private String description;

	private String ean13;

	private BigDecimal stockQty;

	private BigDecimal minStockQty;

	private BigDecimal targetStockQty;

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @return the ean13
	 */
	public String getEan13() {
		return this.ean13;
	}

	/**
	 * @param ean13 the ean13 to set
	 */
	public void setEan13(final String ean13) {
		this.ean13 = ean13;
	}

	/**
	 * @return the stockQty
	 */
	public BigDecimal getStockQty() {
		return this.stockQty;
	}

	/**
	 * @param stockQty the stockQty to set
	 */
	public void setStockQty(final BigDecimal stockQty) {
		this.stockQty = stockQty;
	}

	/**
	 * @return the minStockQty
	 */
	public BigDecimal getMinStockQty() {
		return this.minStockQty;
	}

	/**
	 * @param minStockQty the minStockQty to set
	 */
	public void setMinStockQty(final BigDecimal minStockQty) {
		this.minStockQty = minStockQty;
	}

	/**
	 * @return the targetStockQty
	 */
	public BigDecimal getTargetStockQty() {
		return this.targetStockQty;
	}

	/**
	 * @param targetStockQty the targetStockQty to set
	 */
	public void setTargetStockQty(final BigDecimal targetStockQty) {
		this.targetStockQty = targetStockQty;
	}

    @Override
    protected String getPath() {
        return "products";
    }

}
