package info.san.gs.app.rest.dto;

/**
 * Simple DTO for error display.
 *
 * @author sangelloz-nicoud
 *
 */
public final class ErrorDto {

	private int code;

	private String message;

	/**
	 * Default constructor.
	 *
	 * @param code the status code.
	 * @param message the error message.
	 */
	public ErrorDto(final int code, final String message) {
		super();
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(final int code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

}
