package info.san.gs.app.ddd.command.product;

import java.math.BigDecimal;

import info.san.gs.app.exceptions.InvalidStockQtyException;

/**
 * Helper for validating product command.
 *
 * @author sangelloz-nicoud
 *
 */
public final class ProductCommandValidatorHelper {

	private ProductCommandValidatorHelper() {
		// Nothing.
	}

	/**
	 * Validate a command that write (create or update) a product.
	 *
	 * @param cmd the command to validate.
	 */
	public static void validateWriteCommand(final AbstractWriteProductCommand cmd) {
		if (cmd.getTargetStockQty().compareTo(cmd.getMinStockQty()) <= 0) {
			throw new InvalidStockQtyException("Target stock quantity must be greater than the minimum stock quantity.");
		}
	}

	/**
	 * Validate a commant that remove stock from a product.
	 *
	 * @param cmd the command to validate.
	 */
	public static void validateStockRemoveCommand(final ProductStockRemoveCommand cmd) {
		if (cmd.getQty().compareTo(BigDecimal.ZERO) <= 0) {
			throw new InvalidStockQtyException("Stock quantity to remove must be greater than zero.");
		}
	}

}
