package com.example.demo.pojo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet(urlPatterns = "/mycookie/logout")
public class LogoutServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet 호출 - 로그아웃");
        Cookie c1 = new Cookie("nickname","");//1시간
        c1.setMaxAge(0);
        c1.setPath("/");
        //주의사항 - 쿠키는 로컬에 관리되므로 생성(삭제) 후에는 반드시
        resp.addCookie(c1);
        Cookie c2 = new Cookie("email","");//1시간
        c2.setMaxAge(0);
        c2.setPath("/");
        //주의사항 - 쿠키는 로컬에 관리되므로 생성(삭제) 후에는 반드시
        resp.addCookie(c2);
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    
}
