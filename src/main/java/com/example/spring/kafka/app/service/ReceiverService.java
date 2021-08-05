package com.example.spring.kafka.app.service;

import com.example.spring.kafka.app.event.JoinEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiverService {

    @KafkaListener(topics = "social-push-topic", groupId = "foo")
    public void receiveFromKafka(JoinEvent joinEvent) {
        System.out.println("joinEvent = " + joinEvent.toString());
    }
}
