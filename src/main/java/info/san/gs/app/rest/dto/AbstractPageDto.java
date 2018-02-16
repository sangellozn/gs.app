/**
 *
 */
package info.san.gs.app.rest.dto;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Abstract DTO corresponding to a page of a result for listing all object.
 *
 * @param <DTO> the DTO type for the page.
 *
 * @author sangelloz-nicoud
 */
public abstract class AbstractPageDto<DTO> {

	private final Collection<DTO> data;

	private final long count;

	private final long totalCount;

	private String previousPage;

	private String nextPage;

	protected abstract String getPath();

	protected void computePages(final long currentPage, final long limit) {
		if (currentPage > 0) {
			this.previousPage = this.getPath() + "?p=" + (currentPage - 1) + "&l=" + limit;
		}

		if ((currentPage + 1) * limit < this.totalCount) {
			this.nextPage = this.getPath() + "?p=" + (currentPage + 1) + "&l=" + limit;
		}
	}

	/**
	 * Default constructor.
	 *
	 * @param data data for the page.
	 * @param totalCount the number of total records.
	 * @param currentPage the current page viewed.
	 * @param limit max number of records to retrieve.
	 */
	public AbstractPageDto(final Collection<DTO> data, final long totalCount, final long currentPage, final long limit) {
		this.data = data;
		this.count = data.size();
		this.totalCount = totalCount;
		this.computePages(currentPage, limit);
	}

	/**
	 * @return the data
	 */
	public Collection<DTO> getData() {
		return data;
	}

	/**
	 * @return the count
	 */
	public long getCount() {
		return count;
	}

	/**
	 * @return the totalCount
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * @return the previousPage
	 */
	@JsonProperty("_prev")
	public String getPreviousPage() {
		return previousPage;
	}

	/**
	 * @return the nextPage
	 */
	@JsonProperty("_next")
	public String getNextPage() {
		return nextPage;
	}

}
