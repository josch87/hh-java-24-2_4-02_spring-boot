package com.aljoschazoeller.java.hhjava242_402_springboot.api;

import com.aljoschazoeller.java.hhjava242_402_springboot.domain.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    List<Message> messages = new ArrayList<>();

    @GetMapping
    public ApiResponse<List<Message>> getMessages() {
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCount(messages.size());
        responseInfo.setTimestamp(ZonedDateTime.now());

        ApiResponse<List<Message>> response = new ApiResponse<>();
        response.setInfo(responseInfo);
        response.setData(messages);

        return response;
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<Message>> getMessage(@PathVariable String id) {
        Optional<Message> messageOptional = messages.stream()
                .filter((message) -> message.getId().equals(id))
                .findFirst();

        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setTimestamp(ZonedDateTime.now());

        ApiResponse<Message> response = new ApiResponse<>();

        if (messageOptional.isPresent()) {
            responseInfo.setCount(1);
            response.setInfo(responseInfo);
            response.setData(messageOptional.get());
            return ResponseEntity.ok(response);
        } else {
            responseInfo.setCount(0);
            responseInfo.setMessage("Message with ID " + id + " not found.");
            response.setInfo(responseInfo);
            return ResponseEntity.status(404).body(response);
        }
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
