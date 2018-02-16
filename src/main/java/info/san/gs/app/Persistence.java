package info.san.gs.app;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Datasource for the database connection.
 *
 * @author sangelloz-nicoud
 *
 */
public final class Persistence {

	private static final String DS_NAME = "jdbc/gs.app.db";

	private static final class Holder {
		private static final Persistence INSTANCE = new Persistence();
	}

	public static final Persistence getInstance() {
		return Holder.INSTANCE;
	}

	private Persistence() {
		// Nothing.
	}

	public DataSource getDataSource() {
	    try {
			final Context ctx = new InitialContext();
			return (DataSource) ctx.lookup("java:comp/env/" + DS_NAME);
		} catch (final NamingException ne) {
			throw new RuntimeException(ne);
		}
	}

}
