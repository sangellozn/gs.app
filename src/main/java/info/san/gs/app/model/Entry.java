/**
 *
 */
package info.san.gs.app.model;

import java.util.Date;

/**
 * @author sangelloz-nicoud
 *
 */
public interface Entry {

	String getId();

	Date getUpdatedAt();

	Long getVersion();

	boolean isDeleted();

}
