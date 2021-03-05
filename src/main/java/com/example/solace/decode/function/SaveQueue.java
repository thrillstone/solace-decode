//package com.example.solace.decode.function;
//
//import com.example.solace.decode.model.Queue;
//import com.example.solace.decode.repository.QueueRepository;
//import org.springframework.stereotype.Component;
//
//import java.util.function.Function;
//
//@Component
//public class SaveQueue implements Function<Queue, Queue> {
//	private final QueueRepository queueRepository;
//
//	public SaveQueue(QueueRepository queueRepository) {
//		this.queueRepository = queueRepository;
//	}
//
//	@Override
//	public Queue apply(Queue queue) {
//		return queueRepository.save(queue);
//	}
//}
