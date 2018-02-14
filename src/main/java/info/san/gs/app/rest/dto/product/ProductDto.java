/**
 *
 */
package info.san.gs.app.rest.dto.product;

import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO for product REST services.
 *
 * @author sangelloz-nicoud
 *
 */
public class ProductDto {

	private String id;

	private String name;

	private String description;

	private String ean13;

	private BigDecimal stockQty;

	private BigDecimal minStockQty;

	private BigDecimal targetStockQty;

	private Date createdAt;

	private Date updatedAt;

	private Long version;

	private boolean deleted;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final String id) {
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
	public void setName(final String name) {
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
	public void setDescription(final String description) {
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
	public void setEan13(final String ean13) {
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
	public void setStockQty(final BigDecimal stockQty) {
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
	public void setMinStockQty(final BigDecimal minStockQty) {
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
	public void setTargetStockQty(final BigDecimal targetStockQty) {
		this.targetStockQty = targetStockQty;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(final Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(final Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(final Long version) {
		this.version = version;
	}

	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(final boolean deleted) {
		this.deleted = deleted;
	}

}
