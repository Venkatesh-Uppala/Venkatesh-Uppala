package com.javaexperts.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaConsumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "kafka-topic",groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message received %s",message));
       // kafkaTemplate.receive("kafka-topic",);
    }
}
