package com.microservices.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
public class CurrencyConversion {

	// @Id
	private Long id;

	// @Column(name = "currency_from")
	private String from;

	// @Column(name = "currency_to")
	private String to;

	private BigDecimal conversionMultiple;

	private BigDecimal quantity;

	private BigDecimal totalCalculatedAmount;

	private String environment;

	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
	}

}
