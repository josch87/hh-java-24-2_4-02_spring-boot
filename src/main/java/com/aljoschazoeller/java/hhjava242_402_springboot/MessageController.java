package com.aljoschazoeller.java.hhjava242_402_springboot;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    List<Message> messages = new ArrayList<>();

    @GetMapping
    public List<Message> getMessages() {
        return messages;
    }

    @PostMapping
    public Message addMessage(@RequestBody Message body) {
        messages.add(body);
        return body;
    }
}
