package com.example.solace.decode.config;

import com.solacesystems.jcsmp.InvalidPropertiesException;
import com.solacesystems.jcsmp.JCSMPSession;
import com.solacesystems.jcsmp.SpringJCSMPFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JCSMPSessionConfig {
	private final SpringJCSMPFactory springJCSMPFactory;

	public JCSMPSessionConfig(SpringJCSMPFactory springJCSMPFactory) {
		this.springJCSMPFactory = springJCSMPFactory;
	}

	@Bean
	public JCSMPSession jcsmpSession() throws InvalidPropertiesException {
		return springJCSMPFactory.createSession();
	}
}
