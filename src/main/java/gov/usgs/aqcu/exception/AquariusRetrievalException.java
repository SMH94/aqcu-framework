package gov.usgs.aqcu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AquariusRetrievalException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AquariusRetrievalException(String message) {
		super(message);
	}
}
