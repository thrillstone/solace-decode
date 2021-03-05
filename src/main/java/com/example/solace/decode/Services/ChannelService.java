package com.example.solace.decode.Services;

import com.example.solace.decode.model.Channel;
import com.example.solace.decode.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public List<Channel> getChannels() {
        return channelRepository.findAll();
    }

    @Transactional
    public void createChannel(Channel channel) {
        channelRepository.save(channel);
    }
}


