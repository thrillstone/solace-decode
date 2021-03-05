package com.example.solace.decode.Services;

import com.example.solace.decode.model.Channel;
import com.example.solace.decode.model.Message;
import com.example.solace.decode.repository.ChannelRepository;
import com.example.solace.decode.repository.MessageJPARepository;
import com.example.solace.decode.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChannelService {

    private ChannelRepository channelRepository;

    @Autowired
    private MessageRepository messageRepository;

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public List<Channel> getChannels() {
        return this.channelRepository.findAll();
    }

    public String getChannelSummary(Integer channelId) {
        return this.channelRepository.findChannelById(channelId).getSummary();
    }

    @Transactional
    public void createChannel(Channel channel) {
        channelRepository.save(channel);
    }
}


