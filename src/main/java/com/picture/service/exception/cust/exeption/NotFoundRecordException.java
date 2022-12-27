package com.picture.service.exception.cust.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundRecordException extends RuntimeException {

    /**
	 *
	 */
	private static final long serialVersionUID = -4354117561239653414L;

	public NotFoundRecordException(String msg) {
        super(msg);
    }
	public NotFoundRecordException() {

	}
}
