/**
 *
 */
package info.san.gs.app.rest.webservices;

import java.math.BigDecimal;

import info.san.gs.app.rest.dto.product.ProductDto;
import info.san.gs.app.rest.dto.product.ProductPageDto;

/**
 * @author sangelloz-nicoud
 *
 */
public interface ProductWebservices extends Webservices<ProductDto, ProductPageDto> {

	void stockRemove(String id, BigDecimal qty);

	void stockAdd(String id, BigDecimal qty);

}
