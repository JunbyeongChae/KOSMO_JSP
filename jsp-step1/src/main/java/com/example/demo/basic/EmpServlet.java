package com.example.demo.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
//Jakarta프로젝트에서 제공하는 어노테이션임.
@WebServlet("/emp") //@Controller + @RequestMapping  -Spring boot
public class EmpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  name = new String("이순신");
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        //어! 지금 forward로 할 필요가 없다.
        //시간을 제어한다. - 30분이 기본값 - 세션타임이 톰캣은 기본값이 있다.
        //forward로 하든 아님 redirect로 하시던 차이가 없다.
        resp.sendRedirect("/emp/empList.jsp");
    }
    
}
