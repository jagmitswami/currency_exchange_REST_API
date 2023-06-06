package com.microservices.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.CurrencyConversion;
import com.microservices.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionService currencyConversionService;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		return currencyConversionService.getCurrencyConversionValuesUsingRestTemplate(from, to, quantity);
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveExchangeValueUsingFeignClient(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		return currencyConversionService.getCurrencyConversionValuesUsingRestTemplateUsingFeignClient(from, to, quantity);
	}

}
