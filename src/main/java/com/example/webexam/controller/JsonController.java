package com.example.webexam.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 응답을 Data로 하겠다.
public class JsonController {
    @GetMapping("/hello.json") // Hello클래스가 View의 역할.
    public Hello hello(){ // hello라는 객체를 Spring MVC가 자동으로 JSON으로 만들어준다.
        Hello hello = new Hello();
        hello.setMessage("Hello World!");
        hello.setCount(10);
        return hello;
    }
}

@Data
class Hello{
    private String message;
    private int count;

//    public String getMessage() {
//        return message;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
}
