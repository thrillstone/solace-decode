package com.example.solace.decode.controllers;

import com.example.solace.decode.Services.ChannelService;
import com.example.solace.decode.Services.MessageService;
import com.example.solace.decode.messaging.MessagingService;
import com.example.solace.decode.model.Channel;
import com.example.solace.decode.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "channels")
public class ChannelController {

   private final ChannelService channelService;
   private final MessagingService messagingService;
   private final MessageService messageService;

   @Autowired
    public ChannelController(ChannelService channelService, MessagingService messagingService, MessageService messageService) {
       this.channelService = channelService;
       this.messagingService = messagingService;
       this.messageService = messageService;
   }

    @CrossOrigin
    @GetMapping("{id}/messages")
    public List<Message> getMessagesByChannel(@PathVariable Integer id) {
       return this.messageService.getChannelMessages(id);
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

    @CrossOrigin
    @PostMapping("message")
    public void createMessage(@RequestBody Message message) throws Exception {
        messageService.saveMessage(message);
        messagingService.publish(String.format("channels/%d", message.getChannelId()) , message);
    }
}

