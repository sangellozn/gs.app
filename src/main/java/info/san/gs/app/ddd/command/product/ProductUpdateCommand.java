package info.san.gs.app.ddd.command.product;

import java.math.BigDecimal;

import info.san.gs.app.rest.dto.product.ProductDto;

/**
 * Command that update a product.
 *
 * @author sangelloz-nicoud
 *
 */
public class ProductUpdateCommand extends AbstractWriteProductCommand {

	private ProductUpdateCommand(final Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.description = builder.description;
		this.ean13 = builder.ean13;
		this.stockQty = builder.stockQty;
		this.minStockQty = builder.minStockQty;
		this.targetStockQty = builder.targetStockQty;
	}

	/**
	 * Builder for the command.
	 *
	 * @author sangelloz-nicoud
	 *
	 */
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

}
