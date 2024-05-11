package com.aljoschazoeller.java.hhjava242_402_springboot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
public class Message {
    private String id;
    private String name;
    private String message;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public Message(String id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = ZonedDateTime.now();
    }
}
