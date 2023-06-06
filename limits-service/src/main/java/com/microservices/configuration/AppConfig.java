package com.microservices.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("limits-service")
public class AppConfig {

	private int minimum;
	private int maximum;

}
