package com.example.solace.decode.function;

import com.example.solace.decode.model.es.ESMessage;
import com.example.solace.decode.model.Message;
import com.example.solace.decode.repository.es.ESMessageRepository;
import com.example.solace.decode.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SaveMessage implements Function<Message, Message> {
	private final MessageRepository messageRepository;
	private final ESMessageRepository ESMessageRepository;

	@Autowired
	public SaveMessage(MessageRepository messageRepository, ESMessageRepository ESMessageRepository) {
		this.messageRepository = messageRepository;
		this.ESMessageRepository = ESMessageRepository;
	}

	@Override
	public Message apply(Message message) {
		Message saved = messageRepository.save(message);
		ESMessageRepository.save(new ESMessage(message));
		return saved;
	}
}
