package com.example.webexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // html을 응답을 하는 애플리케이션을 나타내줌
public class HtmlController {
//    @GetMapping("/hello")
//    @ResponseBody // 잘 사용하지 않는다. <- 이렇게 사용하려면 매번 html 태그를 다 적어주어야 해서 힘들다.
//    public String hello(){
//        return "<html><body><h1>Hello World!</h1></body></html>"; // 템플릿 이름을 보통 리턴한다.

@GetMapping("/hello")
public String hello(){
    return "list"; // 뷰 이름. 사용자가 요청을 보낼때 json을 달라. html을 달라. header정보.

    }
}
