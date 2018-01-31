/**
 *
 */
package info.san.gs.app.rest.dto;

import java.util.Collection;

/**
 *
 * Abstract DTO corresponding to a page of a result for listing all object.
 *
 * @author sangelloz-nicoud
 */
public abstract class AbstractPageDto<DTO> {

	private Collection<DTO> data;

	private Long count;

	private Long totalCount;

	private String previousPage;

	private String nextPage;

	/**
	 * @return the data
	 */
	public Collection<DTO> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(final Collection<DTO> data) {
		this.data = data;
	}

	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(final Long count) {
		this.count = count;
	}

	/**
	 * @return the totalCount
	 */
	public Long getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(final Long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the previousPage
	 */
	public String getPreviousPage() {
		return previousPage;
	}

	/**
	 * @param previousPage the previousPage to set
	 */
	public void setPreviousPage(final String previousPage) {
		this.previousPage = previousPage;
	}

	/**
	 * @return the nextPage
	 */
	public String getNextPage() {
		return nextPage;
	}

	/**
	 * @param nextPage the nextPage to set
	 */
	public void setNextPage(final String nextPage) {
		this.nextPage = nextPage;
	}

}
