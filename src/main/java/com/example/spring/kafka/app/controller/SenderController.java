package com.example.spring.kafka.app.controller;

import com.example.spring.kafka.app.service.SenderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SenderController {

    private final SenderSerivce senderSerivce;

    @Autowired
    public SenderController(SenderSerivce senderSerivce) {
        this.senderSerivce = senderSerivce;
    }

    @GetMapping(path = "/send")
    public void send() {
        senderSerivce.sendToKafka("social-push-topic", "Test JoinEvent");
    }
}
