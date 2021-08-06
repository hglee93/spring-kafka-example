package com.example.spring.kafka.app.controller;

import com.example.spring.kafka.app.service.SenderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SenderController {

    private final SenderSerivce senderSerivce;

    @Autowired
    public SenderController(SenderSerivce senderSerivce) {
        this.senderSerivce = senderSerivce;
    }

    @GetMapping(path = "/send")
    @ResponseBody
    public String send() {
        senderSerivce.sendToKafka("social-push-topic", "Test JoinEvent");
        return "send";
    }
}
