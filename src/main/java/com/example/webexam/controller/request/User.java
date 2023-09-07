package com.example.webexam.controller.request;

import lombok.Data;

@Data // getter, setter, toString, equals, hashCodes
public class User {
    private String name;
    private String email;
    private int random;
}
