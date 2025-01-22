package com.example.demo.pojo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet(urlPatterns = "/mycookie/login")
public class LoginServlet extends HttpServlet{
  LoginDao loginDao = new LoginDao();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("doGet");
    String mem_id = req.getParameter("mem_id");
    String mem_pw = req.getParameter("mem_pw");
    log.info("mem_id : " + mem_id + ", mem_pw : " + mem_pw);
    Map<String, Object> pmap = new HashMap<>();
    pmap.put("mem_id", mem_id);
    pmap.put("mem_pw", mem_pw);
    Map<String,Object> rmap = loginDao.login(pmap);
    log.info(rmap.get("MEM_ID")+", "+rmap.get("MEM_NICK"));
    Cookie cid = new Cookie("mem_id", rmap.get("MEM_ID").toString());
    cid.setPath("/");
    cid.setMaxAge(60*60);
    resp.addCookie(cid);
    Cookie cnickname = new Cookie("mem_nick", rmap.get("MEM_NICK").toString());
    cnickname.setPath("/");
    cnickname.setMaxAge(60*60);
    resp.addCookie(cnickname);
    resp.sendRedirect("/index.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("doPost");
    String mem_id = req.getParameter("mem_id");
    String mem_pw = req.getParameter("mem_pw");
    log.info("mem_id : " + mem_id + ", mem_pw : " + mem_pw);
  }
  
}
