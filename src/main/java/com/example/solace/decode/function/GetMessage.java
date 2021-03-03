package com.example.solace.decode.function;

import com.example.solace.decode.model.Message;
import com.example.solace.decode.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GetMessage implements Function<String, Message> {
	private final MessageRepository messageRepository;

	@Autowired
	public GetMessage(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public Message apply(String id) {
		return messageRepository.findById(id).orElse(null);
	}
}
