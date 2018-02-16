package info.san.gs.app.ddd.event.handler;

import org.axonframework.eventhandling.EventHandler;
import org.jdbi.v3.core.locator.ClasspathSqlLocator;

import info.san.gs.app.JdbiConnector;
import info.san.gs.app.ddd.event.product.ProductCreatedEvent;
import info.san.gs.app.ddd.event.product.ProductDeletedEvent;

/**
 * Event handler for product entry related events.
 *
 * @author sangelloz-nicoud
 *
 */
public final class ProductEventHandler {

	@EventHandler
	public void on(final ProductCreatedEvent evt) {
		JdbiConnector.getJdbi().withHandle(h ->
				h.createUpdate(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.product.insert"))
				.bindBean(evt)
				.execute()
		);
	}

	@EventHandler
	public void on(final ProductDeletedEvent evt) {
		JdbiConnector.getJdbi().withHandle(h ->
				h.createUpdate(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.product.delete"))
				.bind("id", evt.getId())
				.execute()
		);
	}

}
