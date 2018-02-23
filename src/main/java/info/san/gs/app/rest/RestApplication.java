/**
 *
 */
package info.san.gs.app.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import info.san.gs.app.rest.exceptions.mapper.InvalidStockQtyExceptionMapper;
import info.san.gs.app.rest.exceptions.mapper.JsonParseExceptionMapper;
import info.san.gs.app.rest.exceptions.mapper.ObjectNotFoundExceptionMapper;
import info.san.gs.app.rest.exceptions.mapper.ValidationExceptionMapper;
import info.san.gs.app.rest.webservices.ProductWebservicesImpl;

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

		classes.add(ProductWebservicesImpl.class);

		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		final Set<Object> singletons = new HashSet<>();

		singletons.add(new JacksonJsonProvider());
		singletons.add(new ObjectNotFoundExceptionMapper());
		singletons.add(new JsonParseExceptionMapper());
		singletons.add(new ValidationExceptionMapper());
		singletons.add(new InvalidStockQtyExceptionMapper());

		return singletons;
	}

}
