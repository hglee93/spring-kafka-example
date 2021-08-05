package com.example.spring.kafka.app.service;

import com.example.spring.kafka.app.event.JoinEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SenderSerivceTest {

    @Autowired SenderSerivce senderSerivce;

    @Test
    void Kafka_Send_Message() {

        for(int i = 0; i < 5; i++) {
            senderSerivce.sendToKafka("social-push-topic", "Test JoinEvent" + i);
        }

    }

}