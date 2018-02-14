/**
 *
 */
package info.san.gs.app.rest.dto;

/**
 * @author sangelloz-nicoud
 *
 */
public abstract class AbstractDto {

	private String id;

	protected abstract String getPath();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}

	public String getSelf() {
		return this.getPath() + "/" + this.getId();
	}

}
