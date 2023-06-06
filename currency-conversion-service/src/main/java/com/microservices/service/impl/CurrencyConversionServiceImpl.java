package com.microservices.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.model.CurrencyConversion;
import com.microservices.service.CurrencyConversionService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	@Override
	public CurrencyConversion getCurrencyConversionValuesUsingRestTemplate(String from, String to,
			BigDecimal quantity) {

		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion currencyConversion = responseEntity.getBody();

		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));

		return currencyConversion;

	}

}
