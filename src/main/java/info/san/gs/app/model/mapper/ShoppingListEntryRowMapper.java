/**
 *
 */
package info.san.gs.app.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import info.san.gs.app.model.ShoppingListEntry;
import info.san.gs.app.model.ShoppingListStateEnum;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShoppingListEntryRowMapper implements RowMapper<ShoppingListEntry> {

	@Override
	public ShoppingListEntry map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final ShoppingListEntry result = new ShoppingListEntry();

		result.setComment(rs.getString("comment"));
		result.setCreatedAt(rs.getTimestamp("created_at"));
		result.setDeleted(rs.getBoolean("deleted"));
		result.setId(rs.getString("id"));
		result.setState(ShoppingListStateEnum.valueOf(rs.getString("state")));
		result.setUpdatedAt(rs.getTimestamp("updated_at"));
		result.setVersion(rs.getLong("version"));

		return result;
	}

}
