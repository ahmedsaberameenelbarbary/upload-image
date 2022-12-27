package com.picture.service.exception.cust.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegistrationException extends RuntimeException {

    /**
	 *
	 */
	private static final long serialVersionUID = -4354117561239653414L;

	public RegistrationException(String msg) {
        super(msg);
    }
	public RegistrationException() {

	}
}
