package com.example.demo.basic;

import java.io.IOException;

import com.example.demo.vo.DeptVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/dept")
public class DeptServlet extends HttpServlet{@Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("doGet call");
    DeptVO dvo = new DeptVO();
    dvo.setDeptno(20);
    dvo.setDname("개발부");
    dvo.setLoc("서울");
    req.setAttribute("dvo", dvo);
    RequestDispatcher view = req.getRequestDispatcher("/dept/deptList.jsp");
    view.forward(req, resp);
  }
  
}
