package com.microservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.exception.CurrencyExchangeException;
import com.microservices.model.CurrencyExchange;
import com.microservices.repository.CurrencyExchangeRepo;
import com.microservices.service.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepo currencyExchangeRepo;

	@Override
	public CurrencyExchange getCurrencyExchangeValues(String from, String to) {
		CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to);
		if (currencyExchange == null) {
			throw new CurrencyExchangeException("No data found for : " + from + " to " + to);
		}
		return currencyExchange;
	}

}
