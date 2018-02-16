/**
 *
 */
package info.san.gs.app.rest.dto.product;

import java.util.Collection;

import info.san.gs.app.rest.dto.AbstractPageDto;

/**
 * @author sangelloz-nicoud
 *
 */
public class ProductPageDto extends AbstractPageDto<ProductDto> {

	public ProductPageDto(final Collection<ProductDto> data, final long totalCount, final long currentPage, final long limit) {
		super(data, totalCount, currentPage, limit);
	}

	@Override
	protected String getPath() {
		return "products";
	}

}
