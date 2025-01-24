package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
//1. 인가코드 - get방식 - 같은 출처 - CORS이슈없다.
//2. 토큰얻기- 8000번으로 처리(톰캣서버나 스프링 서버 경유) - 쿠키와 세션에 저장이 가능함.
@Controller //jsp페이지로 출력이 나갈때 이거나 또는 3000번 요청을 다시 해야  될때
//@RestController //응답이 json포맷으로 나갈때(@Controller+@ResponseBody)
@RequestMapping("/auth/*")
public class KakaoController {
    /*****************************************************************************************
     * 리액트 화면에서 카카오로그인 버튼을 누르면 인가코드를 요청하는URL은 CORS이슈를 피해서 직접 요청을 보내고
     * 두번째 단계인 로그인토큰(POST방식)과 사용자 정보를 요청하는 과정은 백엔드에서 맡아서 처리한다.
     * @param code
     * @return
     *****************************************************************************************/
    @GetMapping("/kakao/callback")
    public String kakaoCallback(String code, HttpSession session) throws UnsupportedEncodingException{
        //인증정보를 백엔드 쿠키나 세션에 관리하기 위해서 토큰받기, 사용자 정보 받아내기는 스프링에서 진행함.
        //encoding 압축, decoding 압축풀기
        //URL로 한글 정보를 넘길 때 전처리가 필요하다. - 크기 초과로 Exception발생함.
        //8000번에서 쿠키나 세션에 저장하고 다시 3000번 서버로 사용자 정보를 넘긴다.
        String encodeName = URLEncoder.encode("강감찬", StandardCharsets.UTF_8.toString());
        String path = "?uid=google1&email=kiwi@hot.com&name="+encodeName;
        //카카오측에서 응답으로 받는 데이터셋에서 세션 혹은 쿠키에 값을 저장하고 나머지 정보는 리액트 서버에게도 전달할것. - 동기화 - 후처리
        /*
         * {
         *      "id": 3235263811, //uid- localStorage저장 = 쿠키나 세션과 동기화 처리
         *      "connected_at": "2025-01-22T11:30:18",
         *      "properties": {
         *          "nickname": "강감찬",
         *          "": ""
         *      }
         * }
         */
        return "redirect:http://localhost:3000/auth/kakao"+path;
    }
}
