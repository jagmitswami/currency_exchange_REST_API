package com.microservices.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CurrencyExchangeException.class)
	public ResponseEntity<MyErrorDetails> currencyExchangeExceptionHandler(CurrencyExchangeException e,
			WebRequest request) {
		MyErrorDetails myErrorDetails = new MyErrorDetails(LocalDateTime.now(), e.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(myErrorDetails, HttpStatus.NOT_FOUND);
	}

}
