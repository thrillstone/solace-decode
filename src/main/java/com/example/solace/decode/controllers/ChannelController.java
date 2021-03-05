package com.example.solace.decode.controllers;

import com.example.solace.decode.Services.ChannelService;
import com.example.solace.decode.messaging.MessagingService;
import com.example.solace.decode.model.Channel;
import com.example.solace.decode.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "channels")
public class ChannelController {

   private final ChannelService channelService;
   private final MessagingService messagingService;

   @Autowired
    public ChannelController(ChannelService channelService, MessagingService messagingService){
       this.channelService = channelService;
       this.messagingService = messagingService;
   }

    @CrossOrigin
    @GetMapping
    public List<Channel> getChannels() {
       return channelService.getChannels();
    }

    @CrossOrigin
    @PostMapping
    public void createChannel(@RequestBody Channel channel) throws Exception {
        channelService.createChannel(channel);
        messagingService.publish("channels", channel);
    }

}

