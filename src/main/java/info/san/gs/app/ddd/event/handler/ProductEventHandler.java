package info.san.gs.app.ddd.event.handler;

import org.axonframework.eventhandling.EventHandler;

import info.san.gs.app.ddd.event.product.ProductCreatedEvent;

public final class ProductEventHandler {

	@EventHandler
	public void on(final ProductCreatedEvent evt) {
		throw new RuntimeException();
		/*JdbiConnector.getJdbi().withHandle(h ->
				h.createUpdate(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.product.insert"))
				.bindBean(evt)
				.execute()
		);*/
	}

}
