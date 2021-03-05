<<<<<<< HEAD
package com.example.solace.decode.function;

import com.example.solace.decode.model.es.ESMessage;
import com.example.solace.decode.repository.MessageRepository;
import com.example.solace.decode.repository.es.ESMessageRepository;
import com.solace.spring.cloud.stream.binder.messaging.SolaceHeaders;
import com.solacesystems.jcsmp.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class SaveMessage implements Consumer<Message<com.example.solace.decode.model.Message>> {
	private final MessageRepository messageRepository;
	private final ESMessageRepository ESMessageRepository;
	private final Pattern channelIdMatcher = Pattern.compile("^channels/(.*?)/");

	@Autowired
	public SaveMessage(MessageRepository messageRepository, ESMessageRepository ESMessageRepository) {
		this.messageRepository = messageRepository;
		this.ESMessageRepository = ESMessageRepository;
	}

	@Override
	public void accept(Message<com.example.solace.decode.model.Message> message) {
		Destination destination = message.getHeaders().get(SolaceHeaders.DESTINATION, Destination.class);
		if (destination != null) {
			Matcher match = channelIdMatcher.matcher(destination.getName());
			if (match.find()) {
				Integer channelId = Integer.valueOf(match.group(1));
				com.example.solace.decode.model.Message payload = message.getPayload();
				payload.setChannelId(channelId);
				messageRepository.save(payload);
				ESMessageRepository.save(new ESMessage(payload));
			}
		}
	}
}
=======
//package com.example.solace.decode.function;
//
//import com.example.solace.decode.model.es.ESMessage;
//import com.example.solace.decode.model.Message;
//import com.example.solace.decode.repository.es.ESMessageRepository;
//import com.example.solace.decode.repository.MessageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.function.Function;
//
//@Component
//public class SaveMessage implements Function<Message, Message> {
//	private final MessageRepository messageRepository;
//	private final ESMessageRepository ESMessageRepository;
//
//	@Autowired
//	public SaveMessage(MessageRepository messageRepository, ESMessageRepository ESMessageRepository) {
//		this.messageRepository = messageRepository;
//		this.ESMessageRepository = ESMessageRepository;
//	}
//
//	@Override
//	public Message apply(Message message) {
////		Message saved = messageRepository.save(message);
////		ESMessageRepository.save(new ESMessage(message));
//		return saved;
//	}
//}
>>>>>>> ff3ee1a5e61ac480a156612f4b7af7d802086852
