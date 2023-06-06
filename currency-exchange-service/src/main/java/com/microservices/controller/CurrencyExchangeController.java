package com.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.CurrencyExchange;
import com.microservices.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
//		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(65));

		CurrencyExchange currencyExchange = currencyExchangeService.getCurrencyExchangeValues(from, to);

		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);

		return currencyExchange;
	}

}
