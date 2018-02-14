/**
 *
 */
package info.san.gs.app.rest.dto;

import java.util.Date;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbProperty;

/**
 * @author sangelloz-nicoud
 *
 */
@JsonbNillable
public abstract class AbstractDto {

	private String id;

	private Date createdAt;

    private Date updatedAt;

    private Long version;

    private boolean deleted;

	protected abstract String getPath();

	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return this.createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return this.version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return the deleted
     */
    public boolean isDeleted() {
        return this.deleted;
    }

    /**
     * @param deleted the deleted to set
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @JsonbProperty("_self")
	public String getSelf() {
		return this.getPath() + "/" + this.getId();
	}

}
