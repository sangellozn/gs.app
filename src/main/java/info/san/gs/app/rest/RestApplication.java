/**
 *
 */
package info.san.gs.app.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import info.san.gs.app.rest.exceptions.mapper.ObjectNotFoundExceptionMapper;
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
		final Set<Class<?>> classes = new HashSet<>();

		classes.add(ProductWebservices.class);

		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		final Set<Object> singletons = new HashSet<>();

		singletons.add(new ObjectNotFoundExceptionMapper());

		return singletons;
	}

}
