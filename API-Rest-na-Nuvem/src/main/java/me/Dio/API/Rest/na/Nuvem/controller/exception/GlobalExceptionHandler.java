package me.Dio.API.Rest.na.Nuvem.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleBusinessException (IllegalArgumentException BusinessException) {
		return new ResponseEntity<>(BusinessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handlenotFoundException (NoSuchElementException notFoundException) {
		var body = "Resource ID not found.";
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleUnexpectedException (Throwable UnexpectedException) {
		var message = "Unexpected server error, see the logs.";
		logger.error("",UnexpectedException);
		return new ResponseEntity<>(message,  HttpStatus.INTERNAL_SERVER_ERROR);
	}
}