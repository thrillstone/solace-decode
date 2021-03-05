package com.example.solace.decode.Services;

import com.example.solace.decode.model.Channel;
import com.example.solace.decode.model.Message;
import com.example.solace.decode.repository.ChannelRepository;
import com.example.solace.decode.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private MessageRepository messageRepository;

    public List<Channel> getChannels() {
        return channelRepository.findAll();
    }

    public long getMessageCount(String channelId) {
        return messageRepository.CountByMessage_ChannelId(channelId);
    }

    public String getChatlog(String channelId) {
        // generates new chatlog
        Pageable topHundred = PageRequest.of(0, 100);
        List<Message> chatlog = messageRepository.findByChannelId(channelId, topHundred);
        String log = "";
        for (Message m: chatlog){
            log += m.getPayload() + ". ";
        }
        return log;
    }

//    call this when new message is created
//    if (channelService.getMessageCount(channelId) % 10 == 0){
//        String log = channelService.getChatlog();
//        messagingService.publish("channels/" + channelId + "/chatlog", log);
//    }

    @Transactional
    public void createChannel(Channel channel) {
        channelRepository.save(channel);
    }
}


