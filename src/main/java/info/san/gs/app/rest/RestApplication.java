/**
 *
 */
package info.san.gs.app.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import info.san.gs.app.rest.webservices.ProductWebservices;

/**
 * Rest application / webservices binding.
 *
 * @author sangelloz-nicoud
 *
 */
@ApplicationPath("rest/api")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> result = new HashSet<>();

		result.add(ProductWebservices.class);

		return result;
	}

	@Override
	public Set<Object> getSingletons() {
		// TODO Auto-generated method stub
		return super.getSingletons();
	}

}
