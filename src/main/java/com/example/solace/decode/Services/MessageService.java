package com.example.solace.decode.Services;

import com.example.solace.decode.model.Message;
import com.example.solace.decode.repository.MessageJPARepository;
import org.elasticsearch.common.inject.Inject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MessageService {

    private MessageJPARepository messageJPARepository;

    @Inject
    public MessageService(MessageJPARepository messageJPARepository) {
        this.messageJPARepository = messageJPARepository;
    }

    public List<Message> getChannelMessages(Integer channelId) {
        return this.messageJPARepository.findByChannelId(channelId);
    }

    @Transactional
    public void saveMessage(Message message) {
        this.messageJPARepository.save(message);
    }


}


