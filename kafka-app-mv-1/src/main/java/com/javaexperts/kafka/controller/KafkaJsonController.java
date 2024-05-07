package com.javaexperts.kafka.controller;

import com.javaexperts.kafka.payload.User;
import com.javaexperts.kafka.producer.KafkaJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaJsonController {

    private final KafkaJsonProducer kafkaJsonProducer;


    public KafkaJsonController(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
