package gov.usgs.aqcu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AquariusProcessingException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AquariusProcessingException(String message) {
		super(message);
	}
}
