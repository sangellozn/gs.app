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
 */
public abstract class AbstractWebservices {

	private final CommandGateway commandGateway;

	public AbstractWebservices() {
		this.commandGateway = AxonContext.getInstance().getCommandGateway();
	}

	public CommandGateway getCommandGateway() {
		return commandGateway;
	}

}
