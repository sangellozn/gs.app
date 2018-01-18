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
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.jdbc.JdbcEventStorageEngine;

import info.san.gs.app.ddd.aggregate.ProductAggregate;

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
		this.commandGateway = new DefaultCommandGateway(commandBus);

		this.eventStorageEngine = new JdbcEventStorageEngine(
				new DataSourceConnectionProvider(Persistence.getInstance().getDataSource()), NoTransactionManager.INSTANCE);

		this.eventStore = new EmbeddedEventStore(eventStorageEngine);

		final Configurer configurer = DefaultConfigurer.defaultConfiguration();
		configurer.configureEmbeddedEventStore(config -> eventStorageEngine);
		configurer.configureCommandBus(config -> this.commandBus);
		configurer.configureEventBus(config -> this.eventStore);

		// Registering aggregates
		configurer.configureAggregate(ProductAggregate.class);
		// others.

		// Registering command handlers.
		//configurer.registerCommandHandler(config -> new AnnotatedCommandHandler());
		// others.

		// Configuring event listeners.
		//configurer.registerModule(module)
		// others.
	}

	/**
	 * @return the commandGateway
	 */
	public CommandGateway getCommandGateway() {
		return commandGateway;
	}

	/**
	 * @return the eventStore
	 */
	public EventStore getEventStore() {
		return eventStore;
	}

	/**
	 * @return the eventStorageEngine
	 */
	public EventStorageEngine getEventStorageEngine() {
		return eventStorageEngine;
	}

	/**
	 * @return the commandBus
	 */
	public CommandBus getCommandBus() {
		return commandBus;
	}

	public static final AxonContext getInstance() {
		return Holder.INSTANCE;
	}

}
