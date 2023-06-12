package com.microservices.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.model.CurrencyConversion;
import com.microservices.proxy.CurrencyExchangeProxy;
import com.microservices.service.CurrencyConversionService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public CurrencyConversion getCurrencyConversionValuesUsingRestTemplate(String from, String to,
			BigDecimal quantity) {

		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion currencyConversion = responseEntity.getBody();

		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		currencyConversion.setEnvironment(currencyConversion.getEnvironment() + " rest template");

		return currencyConversion;

	}

	@Override
	public CurrencyConversion getCurrencyConversionValuesUsingRestTemplateUsingFeignClient(String from, String to,
			BigDecimal quantity) {
		CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);

		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
		currencyConversion.setEnvironment(currencyConversion.getEnvironment() + " feign");

		return currencyConversion;
	}

}
