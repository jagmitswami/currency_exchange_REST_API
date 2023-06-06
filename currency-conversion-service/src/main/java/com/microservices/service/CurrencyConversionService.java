package com.microservices.service;

import java.math.BigDecimal;

import com.microservices.model.CurrencyConversion;

public interface CurrencyConversionService {

	public CurrencyConversion getCurrencyConversionValuesUsingRestTemplate(String fromString, String to, BigDecimal quantity);

}
