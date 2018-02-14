package info.san.gs.app;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import info.san.gs.app.model.mapper.ProductEntryRowMapper;

/**
 *
 * @author sangelloz-nicoud
 *
 */
public final class JdbiConnector {

	private final Jdbi jdbi;

	private static final class Holder {
		private static final JdbiConnector INSTANCE = new JdbiConnector();
	}

	private JdbiConnector() {
		this.jdbi = Jdbi.create(Persistence.getInstance().getDataSource());
		this.jdbi.installPlugin(new SqlObjectPlugin());
		this.jdbi.registerRowMapper(new ProductEntryRowMapper());
	}

	public static final Jdbi getJdbi() {
		return Holder.INSTANCE.jdbi;
	}

}
