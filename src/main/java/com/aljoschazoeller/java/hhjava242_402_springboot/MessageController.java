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

    @DeleteMapping("/{id}")
    public String deleteMessage(@PathVariable String id) {
        boolean isRemoved = messages.removeIf(message -> message.getId().equals(id));
        if (isRemoved) {
            return "Deleted message with ID " + id;
        }
        return "Message with ID " + id + " not found";
    }

}
