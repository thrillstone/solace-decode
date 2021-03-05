package com.example.solace.decode.Services;

import com.example.solace.decode.model.Message;
import com.example.solace.decode.repository.MessageJPARepository;
import org.elasticsearch.common.inject.Inject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public long getMessageCount(Integer channelId) {
        return messageJPARepository.CountByMessage_ChannelId(channelId);
    }

    public String getChatlog(Integer channelId) {
        // generates new chatlog
        Pageable topHundred = PageRequest.of(0, 100);
        List<Message> chatlog = messageJPARepository.findByChannelId(channelId, topHundred);
        String log = "";
        for (Message m: chatlog){
            log += m.getText() + ". ";
        }
        return log;
    }

    @Transactional
    public void saveMessage(Message message) {
        this.messageJPARepository.save(message);
    }


}


