package com.javaexperts.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaExpertsTopic() {
        return TopicBuilder.name("kafka-topic").build();
    }

    @Bean
    public NewTopic javaExpertsJsonTopic() {
        return TopicBuilder.name("kafka-json-topic").build();
    }

}
