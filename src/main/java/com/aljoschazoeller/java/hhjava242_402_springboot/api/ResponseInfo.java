package com.aljoschazoeller.java.hhjava242_402_springboot.api;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
public class ResponseInfo {
    private int count;
    private ZonedDateTime timestamp;
}
