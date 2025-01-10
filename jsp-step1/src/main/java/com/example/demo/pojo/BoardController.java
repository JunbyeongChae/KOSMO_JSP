package com.example.demo.pojo;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardController implements Controller {
  BoardLogic boardLogic = new BoardLogic();

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    // upmu[0] = board, order, notice, member, login
    // upmu[1] = boardList, boardInsert, boardUpdate, boardDelete,
    String upmu[] = (String[]) req.getAttribute("upmu");
    // 스프링은 메소드 위에 GetMapping, PostMapping, PutMapping, DeleteMapping이 지원되니까
    // 이렇게 if문으로 제어를 하지 않아도 되었다.
    // 왜 서블릿에서는 이것이 최선인가? - 개발자가 작성하는 메소드 이름을 알 수 없다.
    // 글 목록 조회할거야?
    log.info(upmu[1]);
    if ("jsonBoardList".equals(upmu[1])) {
      log.info("jsonBoardList");
      // 메소드 호출
      // 인스턴스화 - 누구를 인스턴스화 하면 되나요? XXXLogic.java
      // 주소번지. 메소드이름(싱글톤)
      // 메소드 선언이 아직 안되어 있다. - 메소드 선언을 한다는건 리턴타입과 파라미터결정하는일임
      List<Map<String, Object>> bList = boardLogic.boardList();
      log.info("bList=========>" + bList);
      Gson g = new Gson();
      String temp = g.toJson(bList);
      res.setContentType("application/json; charset=UTF-8");
      //
      PrintWriter out = res.getWriter();
      out.println(temp);
    } else if ("boardList".equals(upmu[1])) {
      // 메소드 호출
      // 인스턴스화 - 누구를 인스턴스화 하면 되나요? XXXLogic.java
      // 주소번지. 메소드이름(싱글톤)
      // 메소드 선언이 아직 안되어 있다. - 메소드 선언을 한다는건 리턴타입과 파라미터결정하는일임
      // List<Map<String,Object>> bList = boardLogic.boardList();
    }
    // 글 등록하기 구현
    else if ("boardInsert".equals(upmu[1])) {
      // 메소드 호출
      // 주소번지. 메소드이름
      // int result = boardLogic.boardInsert();
    }
    // 글 수정하기 구현
    else if ("boardUpdate".equals(upmu[1])) {
      // 메소드 호출
      // 주소번지. 메소드이름
      // int result = boardLogic.boardUpdate();
    }
    // 글 삭제하기 구현
    else if ("boardDelete".equals(upmu[1])) {
      // 메소드 호출
      // 주소번지. 메소드이름
      // int result = boardLogic.boardDelete();
    }
    // 글 상세보기 구현
    else if ("boardDetail".equals(upmu[1])) {
      // 메소드 호출
      // 주소번지. 메소드이름
      Map<String, Object> pmap = new HashMap<>();
      pmap.put("b_no", 1);
      List<Map<String,Object>> bList = boardLogic.boardDetail(pmap);
      log.info(bList.size());
    }
    return null;
  }

}
