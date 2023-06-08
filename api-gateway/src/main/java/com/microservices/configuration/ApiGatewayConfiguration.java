package com.microservices.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gateWayRouteLocator(RouteLocatorBuilder builder) {

		// to add request headers, request parameters
		// to redirect one URI to another URI
		// lb : load balance
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("MyHeader", "MyURI"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**")
						.uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion/**")
						.uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion"))
				.build();
	}

}
