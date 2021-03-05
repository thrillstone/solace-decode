package com.example.solace.decode.messaging;

import com.example.solace.decode.model.Message;
import com.example.solace.decode.repository.MessageJPARepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solacesystems.jcsmp.*;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class MessagingService {
    private String url;
    private String vpnName;
    private String userName;
    private String clientName;
    private String password;
    private Integer reconnectRetries;
    private JCSMPSession session;
    private XMLMessageProducer prod;
    private ObjectMapper objectMapper;
    private XMLMessageConsumer cons;
    private MessageJPARepository messageJPARepository;

    public MessagingService(MessageJPARepository messageJPARepository) throws Exception {
        this.messageJPARepository = messageJPARepository;
        this.url = "tcps://mr1rvhmgxn1b0t.messaging.solace.cloud:55443";
        this.vpnName = "decode";
        this.userName = "solace-cloud-client";
        this.clientName = "server";
        this.password = "tjn2jlk195ntk213e5idk29929";
        this.reconnectRetries = -1;
        final JCSMPProperties properties = new JCSMPProperties();
        properties.setProperty(JCSMPProperties.HOST, url);
        properties.setProperty(JCSMPProperties.USERNAME, userName);
        properties.setProperty(JCSMPProperties.VPN_NAME, vpnName );
        properties.setProperty(JCSMPProperties.CLIENT_NAME, clientName);
        properties.setProperty(JCSMPProperties.PASSWORD, password );


        this.session = JCSMPFactory.onlyInstance().createSession(properties);
        this.objectMapper = new ObjectMapper();
        session.connect();
        this.prod = session.getMessageProducer(new JCSMPStreamingPublishEventHandler() {

            @Override
            public void responseReceived(String messageID) {
                System.out.println("Producer received response for msg: " + messageID);
            }

            @Override
            public void handleError(String messageID, JCSMPException e, long timestamp) {
                System.out.printf("Producer received error for msg: %s@%s - %s%n",
                        messageID,timestamp,e);
            }
        });
        this.cons = session.getMessageConsumer(new XMLMessageListener() {

            @Override
            public void onReceive(BytesXMLMessage msg) {
                try {
                    if (msg instanceof TextMessage) {
                        System.out.printf("TextMessage received: '%s'%n",
                                ((TextMessage) msg).getText());
                    } else {
                        byte[] body = msg.getAttachmentByteBuffer().array();
                        String content = new String(body, StandardCharsets.UTF_8);
                        JsonNode jsonNode = objectMapper.readTree(content);
                        String type = jsonNode.get("type").asText();
                        if (type.equals("message")) {
                            Message message = objectMapper.readValue(content, Message.class);
                            MessagingService.this.messageJPARepository.save(message);
                        }
                        System.out.println("Message received.");
                    }
                    System.out.printf("Message Dump:%n%s%n", msg.dump());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onException(JCSMPException e) {
                System.out.printf("Consumer received exception: %s%n",e);
            }
        });
        cons.start();
        this.subscribe("channels/*/messages");

    }

    public void publish(String topicName, Object content) throws Exception{
        final Topic topic = JCSMPFactory.onlyInstance().createTopic(topicName);
        BytesMessage msg = JCSMPFactory.onlyInstance().createMessage(BytesMessage.class);
        String text = objectMapper.writeValueAsString(content);
        msg.setData(text.getBytes(StandardCharsets.UTF_8));
        prod.send(msg,topic);
    }

    public void subscribe (String topicName) throws Exception{
        final Topic topic = JCSMPFactory.onlyInstance().createTopic(topicName);
        session.addSubscription(topic);
    }




}
