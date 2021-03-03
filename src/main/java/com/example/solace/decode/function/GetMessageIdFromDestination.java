package com.example.solace.decode.function;

import com.solace.spring.cloud.stream.binder.messaging.SolaceHeaders;
import com.solacesystems.jcsmp.Destination;
import org.springframework.messaging.Message;

import java.util.function.Function;

public class GetMessageIdFromDestination implements Function<Message<?>, String> {
	@Override
	public String apply(Message<?> message) {
		Destination destination = message.getHeaders().get(SolaceHeaders.DESTINATION, Destination.class);
		if (destination != null) {
			String[] levels = destination.getName().split("/");
			return levels[levels.length - 1];
		} else {
			return null;
		}
	}
}
