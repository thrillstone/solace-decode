package com.example.solace.decode.repository;

import com.example.solace.decode.model.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageJPARepository extends JpaRepository<Message, String> {
    List<Message> findByChannelId(Integer channelId); //will need to sort here unless frontend wants to do it
    long CountByMessage_ChannelId(Integer channelId);

    // idk which one is better
    // List<Message> findTop100ByChannelId(String channelId);
    List<Message> findByChannelId(@Param("channelId") Integer channelId, Pageable pageable);
}
