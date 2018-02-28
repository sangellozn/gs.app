/**
 *
 */
package info.san.gs.app.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import info.san.gs.app.model.ShoppingListItemEntry;

/**
 * @author sangelloz-nicoud
 *
 */
public class ShppingListItemEntryRowMapper implements RowMapper<ShoppingListItemEntry> {

	@Override
	public ShoppingListItemEntry map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final ShoppingListItemEntry result = new ShoppingListItemEntry();

		result.setCreatedAt(rs.getTimestamp("created_at"));
		result.setDeleted(rs.getBoolean("deleted"));
		result.setId(rs.getString("id"));
		result.setProductId(rs.getString("product_id"));
		result.setQty(rs.getBigDecimal("qty"));
		result.setShoppingListId(rs.getString("shopping_list_id"));
		result.setUpdatedAt(rs.getTimestamp("updated_at"));
		result.setVersion(rs.getLong("version"));

		return result;
	}

}
