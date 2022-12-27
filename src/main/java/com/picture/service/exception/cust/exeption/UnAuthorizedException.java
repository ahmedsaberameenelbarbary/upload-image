package com.picture.service.exception.cust.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnAuthorizedException extends RuntimeException {

    /**
	 *
	 */
	private static final long serialVersionUID = -4354117561239653414L;

	public UnAuthorizedException(String msg) {
        super(msg);
    }
	public UnAuthorizedException() {

	}
}
