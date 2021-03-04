package com.example.solace.decode.controllers;

import com.example.solace.decode.Services.ChannelService;
import com.example.solace.decode.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "channels")
public class ChannelController {

   private final ChannelService channelService;

   @Autowired
    public ChannelController(ChannelService channelService){
       this.channelService = channelService;
   }

    @GetMapping
    public List<Channel> getChannels() {
       return channelService.getChannels();
    }

    @PostMapping
    public void createChannel(Channel channel) {
        channelService.createChannel(channel);
    }
}

