package com.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.configuration.AppConfig;
import com.microservices.model.Limits;

@RestController
public class LimitsController {

	@Autowired
	private AppConfig config;

	@GetMapping("/limits")
	public Limits retriveLimits() {
		return new Limits(config.getMinimum(), config.getMaximum());
//		return new Limits(1, 999);
	}

}
