package com.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.model.CurrencyExchange;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);

}
