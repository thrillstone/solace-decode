package com.example.solace.decode.Services;

import com.example.solace.decode.controllers.Channel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    public List<Channel> getChannels() {
        return List.of(new Channel());
    }

    public void createChannel(Channel channel) {

    }
}


