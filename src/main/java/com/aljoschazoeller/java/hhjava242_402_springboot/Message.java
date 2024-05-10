package com.aljoschazoeller.java.hhjava242_402_springboot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String id;
    private String name;
    private String message;

    public Message(String id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }
}
