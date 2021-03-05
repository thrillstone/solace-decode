package com.example.solace.decode.controllers;

import com.example.solace.decode.Services.ChannelService;
import com.example.solace.decode.Services.MessageService;
import com.example.solace.decode.messaging.MessagingService;
import com.example.solace.decode.model.Channel;
import com.example.solace.decode.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "channels")
public class ChannelController {

    private final ChannelService channelService;
    private final MessagingService messagingService;
    private final MessageService messageService;
    private HashMap<Integer, Integer> messageChannelTracker = new HashMap<Integer, Integer>();

    @Autowired
    public ChannelController(ChannelService channelService, MessagingService messagingService, MessageService messageService) {
        this.channelService = channelService;
        this.messagingService = messagingService;
        this.messageService = messageService;
    }

    @GetMapping("{id}/messages")
    public List<Message> getMessagesByChannel(@PathVariable Integer id) {
        return this.messageService.getChannelMessages(id);
    }

    @GetMapping
    public List<Channel> getChannels() {
        return channelService.getChannels();
    }

    @PostMapping
    public void createChannel(@RequestBody Channel channel) throws Exception {
        channelService.createChannel(channel);
        messagingService.publish("channels", channel);
    }

//    @PostMapping("message")
//    public void createMessage(@RequestBody Message message) throws Exception {
//        Integer channelId = message.getChannelId();
//        messageService.saveMessage(message);
//        messagingService.publish(String.format("channels/%d", channelId), message);
//        if (messageChannelTracker.containsKey(channelId)) {
//            Integer currCount = messageChannelTracker.get(channelId);
//            if (currCount == 10) {
//                List<Message> messages = this.messageService.getChannelMessages(channelId);
//                StringBuilder sb = new StringBuilder();
//                for (Message temp : messages){
//                    sb.append(temp.getText());
//                }
//                messagingService.publish(String.format("channels/%d/chatlog", channelId), sb.toString());
//                messageChannelTracker.put(channelId, 0);
//            } else {
//                messageChannelTracker.put(channelId, currCount + 1);
//            }
//        }
//        else{
//            messageChannelTracker.put(channelId, 1);
//        }
//    }
}

