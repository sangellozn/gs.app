/**
 *
 */
package info.san.gs.app.query.product;

import java.math.BigDecimal;
import java.util.Map;

import info.san.gs.app.model.ProductEntry;
import info.san.gs.app.query.QueryRepository;

/**
 * @author sangelloz-nicoud
 *
 */
public interface ProductQueryRepository extends QueryRepository<ProductEntry> {

	/**
	 * Get for the associated product (by identifier), the quantity need to refill stocks.
	 * <p>
	 * Return all product that have a stock quantity less or equal than the min stock quantity and return
	 * the quantity to get in order to aim the target stock quantity.
	 *
	 * @return a map of product identifier and associated quantity for refilling stocks.
	 */
	Map<String, BigDecimal> getProductQtyToOrder();

}
