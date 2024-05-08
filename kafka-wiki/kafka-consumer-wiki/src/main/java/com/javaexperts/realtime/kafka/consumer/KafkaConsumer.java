package com.javaexperts.realtime.kafka.consumer;

import com.javaexperts.realtime.kafka.entity.WikiMediaData;
import com.javaexperts.realtime.kafka.repository.WikiMediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private WikiMediaDataRepository dataRepository;


    public KafkaConsumer(WikiMediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "wikimedia-recentchange",groupId = "myGroup")
    public void readMessage(String message){

        LOGGER.info(String.format("Event message received  --> %s ",message));

        WikiMediaData wikiMediaData = new WikiMediaData();
        wikiMediaData.setWikiEventData(message);
        dataRepository.save(wikiMediaData);
    }

}
