package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller
public class HelloController {
  @GetMapping("hello")
  public String hello(Model model){
    log.info("hello");
    //화면에서 유지되어야 하는 정보를 넘긴다.-키와 값형태
    //HelloController.java에서 갖고있는 Hello문자열 값을 hello.html에서 사용하고 싶을 때
    //파라미터로 주입되는 Model클래스에 값을 담아두면 사용이 가능하다.
    model.addAttribute("data","shit");
    //return에 있는 hello가 ViewName이다.
    return "hello";//hello확장자에 .html을 붙여서 칮음
  }
}
/*
스프링 부트 thymeleaf viewName매핑
배포위치는 resources : templates/+{ViewName}+".html"
스프링에서 접미어에 .html을 붙여서 응답페이지의 url이름을 호출해줌
*/