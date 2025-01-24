package com.example.demo.pojo;

import java.io.IOException;
import java.util.HashMap;
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
        //아래에서 사용자가 입력한 아이디와 비번을 출력하려면 요청 URL을 어떻게 가져가야 하나요
        //-> http://localhost:8000/mycookie/login?mem_id=kiwi&mem_pw=123
        //<input name="email"/>
        String email = req.getParameter("email");//kiwi
        String mem_pw = req.getParameter("mem_pw");//123
        log.info("사용자가 입력한 ID: " + email + ", 사용자가 입력한 PW: "+mem_pw);
        Map<String,Object> pmap = new HashMap<>();
        pmap.put("email", email);
        pmap.put("mem_pw", mem_pw);
        Map<String,Object> rmap = loginDao.login(pmap);
        //반드시 키값은 대문자로 해야 합니다.
        log.info(rmap.get("EMAIL")+", "+rmap.get("NICKNAME"));
        Cookie cmail = new Cookie("email", rmap.get("EMAIL").toString());
        cmail.setPath("/");
        cmail.setMaxAge(60*60);
        //아래처럼 응답객체로 클라이언트측에 생성된 쿠키를 반드시 내려줄것.
        resp.addCookie(cmail);
        Cookie cnickname = new Cookie("nickname", rmap.get("NICKNAME").toString());
        cnickname.setPath("/");
        cnickname.setMaxAge(60*60);
        resp.addCookie(cnickname);
        resp.sendRedirect("/index.jsp");
    }
    //-> http://localhost:8000/mycookie/login
    //get방식은 화면이 없이도 테스트가 가능하지만 post방식은 javascript나 postman도움이 있어야 테스트 가능함.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doPost");
        String mem_id = req.getParameter("mem_id");
        String mem_pw = req.getParameter("mem_pw");
        log.info("사용자가 입력한 ID: " + mem_id + ", 사용자가 입력한 PW: "+mem_pw);
    }
    
}
