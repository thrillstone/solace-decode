package com.example.solace.decode.function;

import com.example.solace.decode.model.Message;
import lombok.extern.java.Log;
import org.springframework.lang.Nullable;

import java.util.function.Function;

@Log
public class LogMessage implements Function<Message, Message> {

	@Override
	public Message apply(@Nullable Message message) {
		log.info(String.format("Message: %s", message));
		return message;
	}
}
