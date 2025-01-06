package com.example.demo.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/lifecycle") //@WebServlet = @Controller + @RequestMapping
public class SeveletLifeCycle extends HttpServlet{
  
  @Override
  public void init() throws ServletException {
    // 서블릿 초기화 - 서블릿이 생성 또는 리로딩이 될 때 단 한번 수행
    log.info("call init()");
  }
  
  @Override
  //서블릿이 요청 될 때 마다 반복 수행 - 서블릿은 싱글톤
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 입력
    // 2. 처리
    // 3. 출력
    log.info("call service()");
  }

  @Override
  //후처리 - 서블릿이 제거될 때 한번 수행
  //init()과 destroy()는 개발자가 관여하지 않는다.
  public void destroy() {
    log.info("call destroy()");
  }
}
