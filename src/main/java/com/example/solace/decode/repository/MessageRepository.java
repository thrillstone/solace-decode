package com.example.solace.decode.repository;

import com.example.solace.decode.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
