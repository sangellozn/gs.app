/**
 *
 */
package info.san.gs.app.rest.webservices;

import org.axonframework.commandhandling.gateway.CommandGateway;

import info.san.gs.app.AxonContext;

/**
 * Abstract webservice classe.
 *
 * @author sangelloz-nicoud
 *
 * @param <D> the DTO type.
 * @param <P> the page DTO type.
 */
public abstract class AbstractWebservices<D, P> implements Webservices<D, P> {

	private final CommandGateway commandGateway;

	public AbstractWebservices() {
		this.commandGateway = AxonContext.getInstance().getCommandGateway();
	}

	public CommandGateway getCommandGateway() {
		return commandGateway;
	}

}
