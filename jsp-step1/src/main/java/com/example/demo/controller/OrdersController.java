package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController //응답이 html로 나가는게 아니라 json포맷으로 나갈때
@RequestMapping("/orders/*") //주문처리와 관련된 반복되는 폴더이름을 공통으로 분리
public class OrdersController {
    
    //상품목록 조회
    //-> http://localhost:8000/orders/productList
    //사용자가 화면에서 입력한 값을 스프링에서 자동으로 Map에 담아줌 - @RequestParam
    @GetMapping("productList")
    public String productList(@RequestParam Map<String,Object> pMap){
        log.info("productList called ....");
        String result = null;
        return result;
    }//end of productList
    //결제목록
    @GetMapping("payList")
    public String payList(@RequestParam Map<String,Object> pMap){
        log.info("payList called ....");
        String result = null;
        return result;
    }//end of payList
    //카카오 페이 결제 버튼 클릭시 호출하기
    //아래 메소드는 리액트 서버에서 호출하는 메소드 입니다.
    //리액트 화면에서 입력된 값이 파라미터로 들어온다.
    //Postman기준으로 말한다면 Body>raw> { "b_title":"값",  }
    //파라미터 타입을 맞추지 못하면 400번에러나 401번 에러 발동 - 트러블 슈팅 - 타입체크 할것.
    @PostMapping("payReady")
    public String payReady(@RequestBody List<Map<String,Object>> list){
        String result = null;
        return result;
    }

    //결제 승인을 기다리는 상태
    @PostMapping("paySuccess")
    public String paySuccess(@RequestBody Map<String,Object> pMap){
        String result =  null;
        return result;
    }
}
