/**
 *
 */
package info.san.gs.app.rest.webservices;

import java.math.BigDecimal;

import info.san.gs.app.rest.dto.SimpleValueDto;
import info.san.gs.app.rest.dto.product.ProductDto;
import info.san.gs.app.rest.dto.product.ProductPageDto;

/**
 * Webservices related to product entity.
 *
 * @author sangelloz-nicoud
 *
 */
public interface ProductWebservices extends Webservices<ProductDto, ProductPageDto> {

	/**
	 * Remove from the stock the amount qantity for a product.
	 *
	 * @param id the product identifier.
	 * @param qty the quantity to remove.
	 */
	void stockRemove(String id, SimpleValueDto<BigDecimal> qty);

}
