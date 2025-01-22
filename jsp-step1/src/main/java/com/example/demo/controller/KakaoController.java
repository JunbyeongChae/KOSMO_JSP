package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth/*")
public class KakaoController {
  /***********************************
   * 
   * 
   * @param code
   * @return
   **********************************/
  @GetMapping("/kakao/callback")
  public String kakaoCallback(String code, HttpSession session) throws UnsupportedEncodingException{
    String encodeName = URLEncoder.encode("이순신",StandardCharsets.UTF_8.toString());
    String path = "?uid=google1&email=kiwi@hotmail.com&name="+encodeName;

    return "redirect:http://localhost:3000/auth/kakao"+path;
  }
}
