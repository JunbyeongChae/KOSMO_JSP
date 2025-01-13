package com.example.demo.pojo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

@Log4j2
public class BoardController implements Controller{
    BoardLogic boardLogic = new BoardLogic();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //upmu[0] = board, order, notice, member, login
        //upmu[1] = boardList, boardInsert, boardUpdate, boardDelete, 
        String upmu[] = (String[])req.getAttribute("upmu");
        //스프링은 메소드 위에 GetMapping, PostMapping, PutMapping, DeleteMapping이 지원되니까
        //이렇게 if문으로 제어를 하지 않아도 되었다.
        //왜 서블릿에서는 이것이 최선인가? - 개발자가 작성하는 메소드 이름을 알 수 없다.
        //글 목록 조회할거야?
        log.info(upmu[1]);//jsonBoardList출력되는지 확인할 것.
        if("jsonBoardList".equals(upmu[1])){
            log.info("jsonBoardList");
            //메소드 호출
            //인스턴스화 - 누구를 인스턴스화 하면 되나요? XXXLogic.java
            //주소번지. 메소드이름(싱글톤)
            //메소드 선언이 아직 안되어 있다. - 메소드 선언을 한다는건 리턴타입과 파라미터결정하는일임
            List<Map<String,Object>> bList = boardLogic.boardList(null);
            log.info("bList==>"+bList.size());//0이면 조회결과가 없습니다. 1이면 조회결과가 1건임
            Gson g = new Gson();
            String temp = g.toJson(bList);
            res.setContentType("application/json;charset=utf-8");
            //응답객체가 제공하는 getWriter()로 객체생성함.
            //메소드의 리턴타입으로 객체를 생성하는 것은 예를 들어 if문으로
            //null체크와 같은 과정을 거칠 수 있다.
            //만일 34번문장과 아래 문장의 순서를 바꾸면 한글이 깨짐
            PrintWriter out = res.getWriter();
            out.print(temp);
        }
        else if("boardList".equals(upmu[1])){
            //메소드 호출
            //인스턴스화 - 누구를 인스턴스화 하면 되나요? XXXLogic.java
            //주소번지. 메소드이름(싱글톤)
            //메소드 선언이 아직 안되어 있다. - 메소드 선언을 한다는건 리턴타입과 파라미터결정하는일임
            //List<Map<String,Object>> bList = boardLogic.boardList();
            return "forward:list.jsp";
        }
        //글 등록하기 구현
        else if("boardInsert".equals(upmu[1])){
            //메소드 호출
            //주소번지. 메소드이름
            //int result = boardLogic.boardInsert();
        }
        //글 수정하기 구현
        else if("boardUpdate".equals(upmu[1])){
            //메소드 호출
            //주소번지. 메소드이름
            //int result = boardLogic.boardUpdate();
        }
        //글 삭제하기 구현
        else if("boardDelete".equals(upmu[1])){
            //메소드 호출
            //주소번지. 메소드이름
            //int result = boardLogic.boardDelete();
        }
        //글 상세보기 구현
        else if("boardDetail".equals(upmu[1])){
            //메소드 호출
            //주소번지. 메소드이름
            Map<String, Object> pmap = new HashMap<>();
            pmap.put("b_no", 1);
            List<Map<String,Object>> bList = boardLogic.boardDetail(pmap);
            log.info(bList.size());
        }
        return null;
    }
    
}
