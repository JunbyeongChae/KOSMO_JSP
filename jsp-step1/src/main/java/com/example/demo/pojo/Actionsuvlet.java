package com.example.demo.pojo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

//요청URL패턴에 /를 사용하게되면 이 서버에 들어오는 모든 요청이 이 클래스로 유입됨
//의미없느느 확장자이지만 식별자로 사용하기 위해 do를 붙임
//개발자 입장에서 doGet,doPost이든 모두 처리해야 함 - 창구일원화 - 관리유용
//표준 서블릿에서는 메소드마다 URL패턴을 가질 수 없다,
//RestAPI가 아닌 메소드는 구현은 가능하지만 메소드 파라미터에 request와 response
//객체를 주입받지 못함
//웹서비스 구현시 자바는 안되고 서블릿만 되는 이유는 request와 response 제공됨
@Log4j2
@WebServlet("*.do") //@Cotroller와 @RequestMapping이 합쳐짐
public class Actionsuvlet extends HttpServlet {
    public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // -> http://localhost:8000/
    // -> pojo/board/boardList.do
    String uri = req.getRequestURI();
    log.info(uri);
    String context = req.getContextPath();
    String command = uri.substring(context.length()+1);
    int end = command.lastIndexOf(".");
    command = command.substring(0, end);
    String temp[]=null;
    temp = command.split("/");
    String upmu[] =new String[temp.length-1];
    System.arraycopy(temp, 1, upmu, 0, temp.length-1);
    log.info(upmu.length);//4
    req.setAttribute("upmu", upmu);
    BoardController boardController = new BoardController();
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doService(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doService(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doService(req, resp);
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doService(req, resp);
  }
}
