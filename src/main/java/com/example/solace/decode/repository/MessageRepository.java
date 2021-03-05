package com.example.solace.decode.repository;

import com.example.solace.decode.model.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    long CountByMessage_ChannelId(Integer channelId);

    // idk which one is better
    // List<Message> findTop100ByChannelId(String channelId);
    List<Message> findByChannelId(@Param("channelId") Integer channelId, Pageable pageable);
}
