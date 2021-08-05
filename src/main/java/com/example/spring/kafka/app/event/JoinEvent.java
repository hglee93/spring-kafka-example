package com.example.spring.kafka.app.event;

public class JoinEvent {

    private String message;

    public JoinEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JoinEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
