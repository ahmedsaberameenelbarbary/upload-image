package com.picture.service.exception;


import com.picture.service.exception.cust.exeption.InvalidImageException;
import com.picture.service.exception.cust.exeption.NotFoundRecordException;
import com.picture.service.exception.cust.exeption.RegistrationException;
import com.picture.service.exception.cust.exeption.UnAuthorizedException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Log4j2
//@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {


	@ExceptionHandler(RegistrationException.class)
	public ResponseEntity<?> duplicationException(RegistrationException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),"invalid or duplicated email", ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidImageException.class)
	public ResponseEntity<?> invalidImageException(InvalidImageException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UnAuthorizedException.class)
	public ResponseEntity<?> unAuthorizedException(UnAuthorizedException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(NotFoundRecordException.class)
	public ResponseEntity<?> notFoundRecordException(NotFoundRecordException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
