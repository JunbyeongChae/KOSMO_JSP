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
public class DeptServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet호출");
        DeptVO dvo = new DeptVO();
        dvo.setDeptno(20);
        dvo.setDname("개발부");
        dvo.setLoc("서울");
        //jsp파일에서는 내장객체로 제공되는 request풀네임을 다 적음.
        req.setAttribute("dvo", dvo);
        //from.jsp -> to.jsp
        //-> /dept -> /dept/deptList.jsp 이동
        //브라우저에는 /dept를 바라보고 있지만 실제 출력되는 화면은 deptList.jsp이다.
        RequestDispatcher view = req.getRequestDispatcher("/dept/deptList.jsp");
        view.forward(req, resp);
    }//end of doGet
}//end of DeptServlet
