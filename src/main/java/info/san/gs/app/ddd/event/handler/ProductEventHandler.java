package info.san.gs.app.ddd.event.handler;

import org.axonframework.eventhandling.EventHandler;
import org.jdbi.v3.core.locator.ClasspathSqlLocator;

import info.san.gs.app.JdbiConnector;
import info.san.gs.app.ddd.event.product.ProductCreatedEvent;
import info.san.gs.app.ddd.event.product.ProductDeletedEvent;
import info.san.gs.app.ddd.event.product.ProductStockRemoveEvent;
import info.san.gs.app.ddd.event.product.ProductUpdatedEvent;

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

	@EventHandler
	public void on(final ProductUpdatedEvent evt) {
		JdbiConnector.getJdbi().withHandle(h ->
				h.createUpdate(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.product.update"))
				.bindBean(evt)
				.execute()
		);
	}

	@EventHandler
	public void on(final ProductStockRemoveEvent evt) {
		JdbiConnector.getJdbi().withHandle(h ->
				h.createUpdate(ClasspathSqlLocator.findSqlOnClasspath("info.san.gs.app.query.product.removeStock"))
				.bindBean(evt)
				.execute()
		);
	}

}
