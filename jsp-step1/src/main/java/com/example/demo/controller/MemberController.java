package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.logic.MemberLogic;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/member/*")
public class MemberController {
  @Autowired
  private MemberLogic memberLogic = null;
  //로그인관련조회
  //이메일로그인진행
  //소셜로그인진행시 회원가입 유무를 체크하여 강제회원가입 유도시 사용
  //소셜로그인 진행시 MEM_UID유무가 핵심조건
  //닉네임중복검사할 때 이메일 중복검사 할 때
  //POJO와의 가장 큰 차이점은 스프링코드 어디에서도 requst,respons흔적이 ㅇ벗다.
  //스프링부트는 더이상 서블릿에 의존적이지 않은 프레임워크이다,
  @GetMapping("memberList")
  public String memberList(@RequestParam Map<String, Object> pmap) {
    log.info("memberList");
    log.info("pmap : " + pmap);
    Object obj = memberLogic.memberList(pmap);
    String result = null;
    Gson g = new Gson();
    result = g.toJson(obj);
    return result;
  }
}
