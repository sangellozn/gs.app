package info.san.gs.app.ddd.command.product;

import java.math.BigDecimal;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import info.san.gs.app.rest.dto.product.ProductDto;

public class ProductUpdateCommand {

	@TargetAggregateIdentifier
	private final String id;

	private final String name;

	private final String description;

	private final String ean13;

	private final BigDecimal stockQty;

	private final BigDecimal minStockQty;

	private final BigDecimal targetStockQty;

	private ProductUpdateCommand(final Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.description = builder.description;
		this.ean13 = builder.ean13;
		this.stockQty = builder.stockQty;
		this.minStockQty = builder.minStockQty;
		this.targetStockQty = builder.targetStockQty;
	}

	public static final class Builder {

		private final String id;

		private String name;

		private String description;

		private String ean13;

		private BigDecimal stockQty;

		private BigDecimal minStockQty;

		private BigDecimal targetStockQty;

		public Builder(final String id) {
			this.id = id;
		}

		public Builder withName(final String name) {
			this.name = name;
			return this;
		}

		public Builder withDescription(final String description) {
			this.description = description;
			return this;
		}

		public Builder withEan13(final String ean13) {
			this.ean13 = ean13;
			return this;
		}

		public Builder withStockQty(final BigDecimal stockQty) {
			this.stockQty = stockQty;
			return this;
		}

		public Builder withMinStockQty(final BigDecimal minStockQty) {
			this.minStockQty = minStockQty;
			return this;
		}

		public Builder withTargetStockQty(final BigDecimal targetStockQty) {
			this.targetStockQty = targetStockQty;
			return this;
		}

		public ProductUpdateCommand build() {
			return new ProductUpdateCommand(this);
		}

		public ProductUpdateCommand fromDto(final ProductDto dto) {
			this.description = dto.getDescription();
			this.ean13 = dto.getEan13();
			this.minStockQty = dto.getMinStockQty();
			this.name = dto.getName();
			this.stockQty = dto.getStockQty();
			this.targetStockQty = dto.getTargetStockQty();

			return this.build();
		}

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
