package info.san.gs.app.rest.dto;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

/**
 * Helper for DTO validation
 * @author sangelloz-nicoud
 *
 */
public final class DtoValidatorHelper {

	private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

	private DtoValidatorHelper() {
		// Nothing.
	}

	/**
	 * Validate the DTO according to bean annotation.
	 *
	 * @param dto the DTO to validate.
	 */
	public static void validate(final Dto dto) {
		final Set<ConstraintViolation<Dto>> errors = VALIDATOR.validate(dto);

		if (!errors.isEmpty()) {
			throw new ValidationException("Entity validation failed : " +
					String.join(", ", errors.stream().map(error -> error.getPropertyPath()
							+ " " + error.getMessage()).collect(Collectors.toList()).toString()));
		}
	}

}
