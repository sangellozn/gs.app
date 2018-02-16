/**
 *
 */
package info.san.gs.app.ddd.event.product;

import org.axonframework.serialization.Revision;

/**
 * A product is deleted.
 *
 * @author sangelloz-nicoud
 *
 */
@Revision("1.0")
public class ProductDeletedEvent {

	private final String id;

	/**
	 * Defautl constructor.
	 *
	 * @param id identifier of the deleted product.
	 */
	public ProductDeletedEvent(final String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
