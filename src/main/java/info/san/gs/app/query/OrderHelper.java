/**
 *
 */
package info.san.gs.app.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.base.CaseFormat;

import info.san.gs.app.exceptions.InvalidOrderFieldException;
import info.san.gs.app.model.Entry;
import info.san.gs.app.model.ProductEntry;

/**
 * Order helper for computing SQL order by clause.
 *
 * @author sangelloz-nicoud
 *
 */
public final class OrderHelper {

	private static final Map<Class<? extends Entry>, Set<String>> ALLOWED_SORT_FIELDS;

	static {
		final Map<Class<? extends Entry>, Set<String>> tmp = new HashMap<>();

		tmp.put(ProductEntry.class, getAllowedSortFieldSet(ProductEntry.class));

		ALLOWED_SORT_FIELDS = Collections.unmodifiableMap(tmp);
	}

	/**
	 * Placeholder for order by clause in SQL.
	 */
	public static final String ORDER_BY_PLACEHOLDER = "__ORDER_BY__";

	public static String parseOrder(final String rawOrder, final Class<? extends Entry> clazz) {
		if (rawOrder != null && !rawOrder.isEmpty()) {
			final StringBuilder sb = new StringBuilder(" ORDER BY ");
			final Collection<String> orderParts = Arrays.asList(rawOrder.split(","));

			for (final Iterator<String> it = orderParts.iterator(); it.hasNext(); ) {
				final String orderPart = it.next();
				final boolean desc = orderPart.startsWith("-");

				String orderPartTemp = null;
				if (desc) {
					orderPartTemp = orderPart.substring(1);
				} else {
					orderPartTemp = orderPart;
				}

				if (!ALLOWED_SORT_FIELDS.getOrDefault(clazz, new HashSet<>()).contains(orderPartTemp)) {
					throw new InvalidOrderFieldException("Cannot sort on '" + orderPartTemp + "' field.");
				}

				sb.append(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, orderPartTemp))
					.append(' ')
					.append(desc ? "DESC" : "ASC");

				if (it.hasNext()) {
					sb.append(", ");
				}
			}

			return sb.toString();
		}

		return null;

	}

	protected static Set<String> getAllowedSortFieldSet(final Class<? extends Entry> clazz) {

		return null; //FIXME

	}

}
