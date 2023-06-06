package com.microservices.exception;

@SuppressWarnings("serial")
public class CurrencyExchangeException extends RuntimeException {

	public CurrencyExchangeException(String msg) {
		super(msg);
	}

}
