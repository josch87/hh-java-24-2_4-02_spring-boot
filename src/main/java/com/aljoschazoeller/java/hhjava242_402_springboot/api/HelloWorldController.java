package com.aljoschazoeller.java.hhjava242_402_springboot.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {

    @GetMapping
    public String getHelloWorld() {
        return "Hello, World!";
    }

    @GetMapping("{name}")
    public String getHelloSomeone(@PathVariable String name) {
        return "Hello, " + name;
    }
}
