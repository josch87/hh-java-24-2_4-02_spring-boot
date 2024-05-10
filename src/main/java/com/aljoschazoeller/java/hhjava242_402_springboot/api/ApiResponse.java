package com.aljoschazoeller.java.hhjava242_402_springboot.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private ResponseInfo info;
    private T data;
}
