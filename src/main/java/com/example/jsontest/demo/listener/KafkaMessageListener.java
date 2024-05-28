package com.example.jsontest.demo.listener;

import com.example.jsontest.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class KafkaMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @Autowired
    private MessageService messageService;

    @KafkaListener(topics = "topic_0", groupId = "java-group-1")
    public void listen(String message) {
        // add logging here
        // Log the received message
        logger.info("Received message: {}", message);

        messageService.sendMessageToEndpoint(message);
    }
}
