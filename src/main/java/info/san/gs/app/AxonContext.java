/**
 *
 */
package info.san.gs.app;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.common.jdbc.DataSourceConnectionProvider;
import org.axonframework.common.transaction.NoTransactionManager;
import org.axonframework.config.Configurer;
import org.axonframework.config.DefaultConfigurer;
import org.axonframework.config.EventHandlingConfiguration;
import org.axonframework.eventhandling.PropagatingErrorHandler;
import org.axonframework.eventhandling.SimpleEventHandlerInvoker;
import org.axonframework.eventhandling.SubscribingEventProcessor;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.jdbc.JdbcEventStorageEngine;

import info.san.gs.app.ddd.aggregate.ProductAggregate;
import info.san.gs.app.ddd.aggregate.ShoppingListAggregate;
import info.san.gs.app.ddd.command.handler.ProductCommandHandler;
import info.san.gs.app.ddd.command.handler.ShoppingListCommandHandler;
import info.san.gs.app.ddd.event.handler.ProductEventHandler;
import info.san.gs.app.ddd.event.handler.ShoppingListEventHandler;

/**
 * Classe de context pour AxonFramework.
 */
public final class AxonContext {

	private final CommandGateway commandGateway;

	private final EventStore eventStore;

	private final EventStorageEngine eventStorageEngine;

	private final CommandBus commandBus;

	private static final class Holder {
		private static final AxonContext INSTANCE = new AxonContext();
	}

	private AxonContext() {
		this.commandBus = new SimpleCommandBus();
		this.commandGateway = new DefaultCommandGateway(this.commandBus);

		this.eventStorageEngine = new JdbcEventStorageEngine(
				new DataSourceConnectionProvider(Persistence.getDataSource()), NoTransactionManager.INSTANCE);

		this.eventStore = new EmbeddedEventStore(this.eventStorageEngine);

		final Configurer configurer = DefaultConfigurer.defaultConfiguration();
		configurer.configureEmbeddedEventStore(config -> this.eventStorageEngine);
		configurer.configureCommandBus(config -> this.commandBus);
		configurer.configureEventBus(config -> this.eventStore);

		// Registering aggregates
		configurer.configureAggregate(ProductAggregate.class);
		configurer.configureAggregate(ShoppingListAggregate.class);
		// others aggregates.

		// Registering command handlers.
		configurer.registerCommandHandler(config -> new ProductCommandHandler());
		configurer.registerCommandHandler(config -> new ShoppingListCommandHandler(new EventSourcingRepository<>(ShoppingListAggregate.class, this.eventStore)));
		// others command handlers.

		// Configuring event listeners.
		final EventHandlingConfiguration eventHandlingModule =  new EventHandlingConfiguration();
		eventHandlingModule.registerEventHandler(config -> new ProductEventHandler());
		eventHandlingModule.registerEventHandler(config -> new ShoppingListEventHandler());
		// others event handlers.

		eventHandlingModule.registerEventProcessor("default", (config, name, eh) -> new SubscribingEventProcessor(name,
		        new SimpleEventHandlerInvoker(eh, PropagatingErrorHandler.INSTANCE), this.eventStore));
		eventHandlingModule.assignHandlersMatching("default", (criteria) -> true);

		configurer.registerModule(eventHandlingModule);
		configurer.start();
	}

	/**
	 * @return the commandGateway
	 */
	public CommandGateway getCommandGateway() {
		return this.commandGateway;
	}

	/**
	 * @return the eventStore
	 */
	public EventStore getEventStore() {
		return this.eventStore;
	}

	/**
	 * @return the eventStorageEngine
	 */
	public EventStorageEngine getEventStorageEngine() {
		return this.eventStorageEngine;
	}

	/**
	 * @return the commandBus
	 */
	public CommandBus getCommandBus() {
		return this.commandBus;
	}

	/**
	 * Get the {@link AxonContext} instance.
	 *
	 * @return the AxonContext instance.
	 */
	public static final AxonContext getInstance() {
		return Holder.INSTANCE;
	}

}
