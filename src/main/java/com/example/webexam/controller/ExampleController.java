package com.example.webexam.controller;

import com.example.webexam.controller.request.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

// http://localhost:9090/example
@RestController // json, xml 데이터를 반환하는 컨트롤러로 사용
@RequestMapping("/example")
public class ExampleController {

    // GET방식으로 http://localhost:9090/example/1
    // 컨트롤러 핸들러
    @GetMapping("/1")
    public String example1(){
        return "example1"; // 그냥 컨트롤러에서는 템플릿 이름을 리턴. 여기선 스트링을 그대로 리턴해줌.
    }

    // GET방식으로 http://localhost:9090/example/1
    @GetMapping("/2")
    public String example2(HttpServletRequest request){ // 브라우저의 요청값을 이 핸들러가 그대로 받는다.
        System.out.println(request);
        return "example1";
    }

    // form으로부터 넘어오는 값을 어떻게 받느냐?
    //  <input type="text" name="name" placeholder="name">
    //  <input type="text" name="email" placeholder="email">
    @PostMapping("/3")
    public String example3(@RequestParam(name = "name", required = true) String name,
                           @RequestParam(name = "email", required = false, defaultValue = "empty_email") String email){ // 브라우저의 요청값을 이 핸들러가 그대로 받는다.
        System.out.println(name);
        System.out.println(email);
//        System.out.println(request.getParameter("name"));
//        System.out.println(request.getParameter("email"));
        return "example3";
    }


    // RestController는 브라우저에서 동작하는 javascript가 보통 호출한다.
    // javascript가 호출할때는 json데이터를 post방식으로 body에 담아서 전송한다.
    // 백엔드개발자가 javascript를 작성해서 테스트를 해야하나?? -> javascript가 없어도 테스르틑 할 수 있는 도구가 필요하다. -> Postman
    // RestController에서 객체를 반환하면 json으로 변환된다.(헤더에 데이터를 담아서 보내면 xml이나 josn 결과가 나온다)
    // content-type을 application/json으로 하면 요청 바디에 json데이터를 담아서 보낸다.
    // Accept에 application/xml로 하면 리턴한 객체(User)를 xml로 변환해서 응답으로 보낸다.
    @PostMapping("/4")
    public User example4(@RequestBody User user){ // 브라우저의 요청값을 이 핸들러가 그대로 받는다.
        System.out.println(user);
        user.setRandom(new Random().nextInt(100));
        return user;
    } // Converter가 JSON문자열을 User객체로 변환해주게 된다. 뿐만 아니라 xml, 엑셀등도 이것을 이용해서 변환 할 수 있다.

    // http://localhost:9090/example/pathexam/어떤특정값
    @GetMapping("/pathexam/{id}")
    public String pathExam(@PathVariable(name = "id") String id){
        System.out.println(id);
        return "pathExam";
    }

    // http://localhost:9090/example/headerexam
    @GetMapping("/headerexam")
    public String headerExam(@RequestHeader(name = "User-Agent") String userAgentValue){
        System.out.println(userAgentValue);
        return "headerexam";
    }


}
