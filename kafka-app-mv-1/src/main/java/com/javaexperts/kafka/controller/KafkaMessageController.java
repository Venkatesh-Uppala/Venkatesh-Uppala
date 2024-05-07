package com.javaexperts.kafka.controller;

import com.javaexperts.kafka.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaMessageController {

    private KafkaProducer kafkaProducer;

    public KafkaMessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
    kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully to topic");
    }
}
