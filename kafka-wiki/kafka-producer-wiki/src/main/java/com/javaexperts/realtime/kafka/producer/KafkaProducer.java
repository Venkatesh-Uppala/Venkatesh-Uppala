package com.javaexperts.realtime.kafka.producer;

import com.javaexperts.realtime.kafka.WikiMediaChangeHandler;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.StreamException;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws StreamException, InterruptedException {
        String topic= "wikimedia-recentchange";

        // To read realtime stream data from wikimedia, we use event source
        BackgroundEventHandler eventHandler = new WikiMediaChangeHandler(topic,kafkaTemplate);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource.Builder builder = new EventSource.Builder(URI.create(url));
        BackgroundEventSource eventSource = new BackgroundEventSource.Builder(eventHandler,builder).build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);

    }
}
