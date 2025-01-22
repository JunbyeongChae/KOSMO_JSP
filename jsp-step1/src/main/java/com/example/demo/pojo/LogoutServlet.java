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
    log.info("doGet call - Logout");
    Cookie c1 = new Cookie("mem_nick", "");
    c1.setMaxAge(0);
    c1.setPath("/");
    resp.addCookie(c1);
    Cookie c2 = new Cookie("mem_id", "");
    c2.setMaxAge(0);
    c2.setPath("/");
    resp.addCookie(c2);
    resp.sendRedirect("/index.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  }
  
}
