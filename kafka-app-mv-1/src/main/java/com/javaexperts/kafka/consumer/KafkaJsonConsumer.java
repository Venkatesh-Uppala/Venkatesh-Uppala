package com.javaexperts.kafka.consumer;

import com.javaexperts.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "kafka-json-topic",groupId = "myGroup")
    public void consume(User data) {
        LOGGER.info(String.format("Json Message received --> %s",data.toString()));
    }
}
