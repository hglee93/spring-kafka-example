package com.example.spring.kafka.app.event;

public class JoinEvent {

    private String message;

    public JoinEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
