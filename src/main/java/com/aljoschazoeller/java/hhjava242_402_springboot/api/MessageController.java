package com.aljoschazoeller.java.hhjava242_402_springboot.api;

import com.aljoschazoeller.java.hhjava242_402_springboot.domain.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    List<Message> messages = new ArrayList<>();

    @GetMapping
    public List<Message> getMessages() {
        return messages;
    }

    @GetMapping("{id}")
    public Message getMessage(@PathVariable String id) {
        Optional<Message> messageOptional = messages.stream()
                .filter((message) -> message.getId().equals(id))
                .findFirst();

        return messageOptional.orElse(null);
    }

    @PostMapping
    public Message addMessage(@RequestBody Message body) {
        body.setId(UUID.randomUUID().toString());
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
