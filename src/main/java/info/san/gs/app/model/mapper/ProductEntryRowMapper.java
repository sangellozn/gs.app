/**
 *
 */
package info.san.gs.app.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import info.san.gs.app.model.ProductEntry;

/**
 * @author sangelloz-nicoud
 *
 */
public class ProductEntryRowMapper implements RowMapper<ProductEntry> {

	/* (non-Javadoc)
	 * @see org.jdbi.v3.core.mapper.RowMapper#map(java.sql.ResultSet, org.jdbi.v3.core.statement.StatementContext)
	 */
	@Override
	public ProductEntry map(final ResultSet rs, final StatementContext ctx) throws SQLException {
		final ProductEntry result = new ProductEntry();

		result.setCreatedAt(rs.getDate("created_at"));
		result.setDeleted(rs.getBoolean("deleted"));
		result.setDescription(rs.getString("description"));
		result.setEan13(rs.getString("ean13"));
		result.setId(rs.getString("id"));
		result.setMinStockQty(rs.getBigDecimal("min_stock_qty"));
		result.setName(rs.getString("name"));
		result.setStockQty(rs.getBigDecimal("stock_qty"));
		result.setTargetStockQty(rs.getBigDecimal("target_stock_qty"));
		result.setUpdatedAt(rs.getDate("updated_at"));
		result.setVersion(rs.getLong("version"));

		return result;
	}

}
