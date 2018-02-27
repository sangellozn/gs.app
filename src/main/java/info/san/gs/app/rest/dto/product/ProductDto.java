/**
 *
 */
package info.san.gs.app.rest.dto.product;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import info.san.gs.app.rest.dto.AbstractDto;

/**
 * DTO for product REST services.
 *
 * @author sangelloz-nicoud
 *
 */
public class ProductDto extends AbstractDto {

	@NotBlank(message = "must be not blank")
	@Size(max = 100, message = "must be less than 100 characters")
	private String name;

	@NotBlank(message = "must be not blank")
	@Size(max = 255, message = "must be less than 255 characters")
	private String description;

	@NotBlank(message = "must be not blank")
	@Pattern(regexp = "[0-9]{13}", message = "must be a 13 digits string")
	private String ean13;

	@PositiveOrZero(message = "must be positive or zero")
	private BigDecimal stockQty;

	@PositiveOrZero(message = "must be positive or zero")
	private BigDecimal minStockQty;

	@PositiveOrZero(message = "must be positive or zero")
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
