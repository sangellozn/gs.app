/**
 *
 */
package info.san.gs.app.ddd.command.handler;

/**
 * Handler for command associated with product.
 *
 * @author sangelloz-nicoud
 *
 */
public class ProductCommandHandler {

	//private final EventSourcingRepository<ProductAggregate> repository = new EventSourcingRepository<>(ProductAggregate.class, AxonContext.getInstance().getEventStore());

	/*@CommandHandler
	public void handle(final ProductCreateCommand cmd) {
		repository.newInstance(() -> new ProductAggregate(cmd));
	}*/

}
