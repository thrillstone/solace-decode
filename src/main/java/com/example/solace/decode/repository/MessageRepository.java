package com.example.solace.decode.repository;

import com.example.solace.decode.model.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
}
