<<<<<<< HEAD
package com.example.solace.decode.function;

import com.solace.spring.cloud.stream.binder.messaging.SolaceHeaders;
import com.solacesystems.jcsmp.Destination;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

import java.util.function.Function;

public class GetMessageIdFromDestination implements Function<Message<?>, String> {
	@Override
	public String apply(Message<?> message) {
		Destination destination = message.getHeaders().get(SolaceHeaders.DESTINATION, Destination.class);
		if (destination != null) {
			String[] levels = destination.getName().split("/");
			return levels[levels.length - 1];
		} else {
			// Shouldn't ever come here in reality
			throw new MessagingException("no destination");
		}
	}
}
=======
//package com.example.solace.decode.function;
//
//import com.solace.spring.cloud.stream.binder.messaging.SolaceHeaders;
//import com.solacesystems.jcsmp.Destination;
//import org.springframework.messaging.Message;
//
//import java.util.function.Function;
//
//public class GetMessageIdFromDestination implements Function<Message<?>, String> {
//	@Override
//	public String apply(Message<?> message) {
//		Destination destination = message.getHeaders().get(SolaceHeaders.DESTINATION, Destination.class);
//		if (destination != null) {
//			String[] levels = destination.getName().split("/");
//			return levels[levels.length - 1];
//		} else {
//			return null;
//		}
//	}
//}
>>>>>>> ff3ee1a5e61ac480a156612f4b7af7d802086852
