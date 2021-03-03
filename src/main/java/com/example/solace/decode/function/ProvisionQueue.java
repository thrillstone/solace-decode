package com.example.solace.decode.function;

import com.example.solace.decode.model.Queue;
import com.solacesystems.jcsmp.EndpointProperties;
import com.solacesystems.jcsmp.JCSMPException;
import com.solacesystems.jcsmp.JCSMPFactory;
import com.solacesystems.jcsmp.JCSMPSession;
import lombok.extern.java.Log;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Log
public class ProvisionQueue implements Function<String, Queue> {
	private final JCSMPSession jcsmpSession;

	public ProvisionQueue(JCSMPSession jcsmpSession) {
		this.jcsmpSession = jcsmpSession;
	}

	@Override
	public Queue apply(String name) {
		com.solacesystems.jcsmp.Queue jcsmpQueue = JCSMPFactory.onlyInstance().createQueue(name);
		try {
			jcsmpSession.provision(jcsmpQueue, new EndpointProperties(), JCSMPSession.FLAG_IGNORE_ALREADY_EXISTS);
		} catch (JCSMPException e) {
			throw new MessagingException("Cannot create queue " + name, e);
		}

		Queue queue = new Queue();
		queue.setName(jcsmpQueue.getName());
		log.info(String.format("Message: %s", queue));
		return queue;
	}
}
