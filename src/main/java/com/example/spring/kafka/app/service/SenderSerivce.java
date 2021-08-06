package com.example.spring.kafka.app.service;

import com.example.spring.kafka.app.event.JoinEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class SenderSerivce {

    private final KafkaTemplate kafkaTemplate;

    private static final Logger log = LoggerFactory.getLogger(SenderSerivce.class);

    @Autowired
    public SenderSerivce(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToKafka(String topic, String message) {
        JoinEvent joinEvent = new JoinEvent();
        joinEvent.setMessage(message);
        ListenableFuture<SendResult<String, JoinEvent>> future = kafkaTemplate.send(topic, joinEvent);
        future.addCallback(new KafkaSendCallback<String, JoinEvent>() {

            @Override
            public void onSuccess(SendResult<String, JoinEvent> stringJoinEventSendResult) {
                log.info("JoinEvent(" + joinEvent.toString() + ") publish!");
            }

            @Override
            public void onFailure(KafkaProducerException e) {
                log.info("JoinEvent(" + joinEvent.toString() + ") fail! -> {} ", e, e.getMessage());
            }

        });
    }
}
