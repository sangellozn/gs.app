package info.san.gs.app.ddd.command.product;

import java.math.BigDecimal;
import java.util.UUID;

import info.san.gs.app.rest.dto.product.ProductDto;

/**
 * Create a product.
 *
 * @author sangelloz-nicoud
 */
public class ProductCreateCommand extends AbstractWriteProductCommand {

	private ProductCreateCommand(final Builder builder) {
		this.id = UUID.randomUUID().toString();
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

		private String name;

		private String description;

		private String ean13;

		private BigDecimal stockQty;

		private BigDecimal minStockQty;

		private BigDecimal targetStockQty;

		/**
		 * Assign name.
		 *
		 * @param name the name.
		 *
		 * @return the builder.
		 */
		public Builder withName(final String name) {
			this.name = name;
			return this;
		}

		/**
		 * Assign description.
		 *
		 * @param description the description.
		 *
		 * @return the builder.
		 */
		public Builder withDescription(final String description) {
			this.description = description;
			return this;
		}

		/**
		 * Assign ean 13.
		 *
		 * @param ean13 the ean 13.
		 *
		 * @return the builder.
		 */
		public Builder withEan13(final String ean13) {
			this.ean13 = ean13;
			return this;
		}

		/**
		 * Assign the current stock qty.
		 *
		 * @param stockQty the stock qty.
		 *
		 * @return the builder.
		 */
		public Builder withStockQty(final BigDecimal stockQty) {
			this.stockQty = stockQty;
			return this;
		}

		/**
		 * Assign the minimum qantity that will place the item to the next shopping list.
		 *
		 * @param minStockQty minimum quantity (inclusive value).
		 *
		 * @return the builder.
		 */
		public Builder withMinStockQty(final BigDecimal minStockQty) {
			this.minStockQty = minStockQty;
			return this;
		}

		/**
		 * Assign the target stock qty.
		 *
		 * @param targetStockQty the targeted quantity in stock.
		 *
		 * @return the builder.
		 */
		public Builder withTargetStockQty(final BigDecimal targetStockQty) {
			this.targetStockQty = targetStockQty;
			return this;
		}

		/**
		 * Build the product command.
		 *
		 * @return the new product command.
		 */
		public ProductCreateCommand build() {
			return new ProductCreateCommand(this);
		}

		/**
		 * Create a command from a product dto.
		 *
		 * @param dto the init dto.
		 *
		 * @return the corresponding product command.
		 */
		public ProductCreateCommand fromDto(final ProductDto dto) {
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
