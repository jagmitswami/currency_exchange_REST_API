package com.microservices.service;

import com.microservices.model.CurrencyExchange;

public interface CurrencyExchangeService {

	public CurrencyExchange getCurrencyExchangeValues(String fromString, String to);
	
}
