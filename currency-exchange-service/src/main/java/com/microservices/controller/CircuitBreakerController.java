package com.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CircuitBreakerController {

	@GetMapping("/sample-api")
	// @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	// @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	// @RateLimiter(name = "default")
	@Bulkhead(name = "sample-api")
	public String sampleAPI() {
		log.info("sample api call recived");
//		ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8000/xyz", String.class);
//		return entity.getBody();

		return "sameple api called";
	}

	@SuppressWarnings("unused")
	private String hardcodedResponse(Exception exception) {
		return "Fallback response";
	}

}
