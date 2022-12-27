package com.picture.service.exception.cust.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidImageException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 8791923496388627990L;

	public InvalidImageException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidImageException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidImageException(String msg) {
		super(msg);
	}

}
