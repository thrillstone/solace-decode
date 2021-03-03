package com.example.solace.decode.function;

import com.example.solace.decode.model.Queue;
import lombok.extern.java.Log;
import org.springframework.lang.Nullable;

import java.util.function.Function;

@Log
public class LogQueue implements Function<Queue, Queue> {

	@Override
	public Queue apply(@Nullable Queue queue) {
		log.info(String.format("Message: %s", queue));
		return queue;
	}
}
