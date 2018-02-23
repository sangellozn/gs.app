package info.san.gs.app.rest.dto;

/**
 * DTO wrapping a single value field.
 *
 * @author sangelloz-nicoud
 *
 * @param <T> the value type.
 */
public class SimpleValueDto<T> implements Dto {

	private T value;

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(final T value) {
		this.value = value;
	}

}
