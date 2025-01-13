package com.example.demo.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/lifecycle")  // @WebServlet = @Controller + @RequestMapping
public class ServletLifeCycle extends HttpServlet{
    @Override
    public void init() throws ServletException {
        // 서블릿 초기화 - 서블릿이 생성 또는 리로딩이 될 때, 단 한 번만 수행됨.
        log.info("init() call");
    }
    //서블릿이 요청될 때 마다 반복적으로 수행됨. - 서블릿은 싱글톤
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 입력
        //2. 처리
        //3. 출력
        log.info("service() call");
    }
    //후처리시 - 서블릿이 제거 될 때 단 한 번만 수행됨.
    //init()과 destroy()는 개발자가 관여하지 않는다.
    @Override
    public void destroy() {
        log.info("destroy() call");
    }

}
