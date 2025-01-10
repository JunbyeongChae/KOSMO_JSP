package com.example.demo.pojo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

//요청 URL패턴에 /를 사용하게 되면 이 서버에 들어오는 모든 요청이 이 클래스로 유입됨
//의미없는 확장자 이지만 식별자로 사용하기 위해서 do를 붙임
//개발자 입장에서는 doGet, doPost이든 모두 처리를 해야 합니다. - 창구 일원화 - 관리
//표준 서블릿에서는 메소드마다 URL패턴을 가질 수 없다.
//Rest API가 아닌 메소드는 구현할 수는 있겠지만 메소드 파라미터에 request와 response
//객체를 주입받지 못함.
//웹 서비스 구현시 자바는 안되고 서블릿만 되는 이유는 request, response제공됨
@WebServlet("*.do") //@Controller와 @RequestMapping 합쳐짐
@Log4j2 //롬복에서 객체 주입을 해줌 - getter/setter - 객체 주입법 그대로 적용
public class ActionServlet extends HttpServlet{
    public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        // -> http://localhost:8000/
        // -> pojo/board/boardList.do -> 20
        // -> pojo/board/jsonBoardList.do -> 20
        // -> pojo/board/boardInsert.do -> 22
        // -> pojo/board/boardUpdate.do -> 22
        // -> pojo/board/boardDelete.do -> 21
        String uri = req.getRequestURI();
        log.info(uri);// home
        String context = req.getContextPath(); //server.xml -> jsp-step1플젝 배포 -> 루트
        log.info(context);// -> /
        //substring메소드는 문자열을 잘라줌
        String command = uri.substring(context.length()+1);//-> pojo/board/jsonBoardList.do
        int end = command.lastIndexOf(".");//20 - .do의 이전위치 정보를 계산함. 24
        //pojo/board/boardList
        //pojo/board/boardInsert
        //pojo/board/boardUpdate
        //pojo/board/boardDelete
        command = command.substring(0, end);//문자열뒤에 substring함수를 붙임. 파라미터 구간을 정함
        //요청 URL맨 앞에 pojo는 react서버에서 다른 출처인 경우 CORS이슈로 요청이 전달되지 못함.
        //3000번에서 8000번 출처로 요청이 바뀌면 프록시 활용하여 요청을 전달 함. - CORS이슈 묵인
        //우리는 배열에 값이 두 개면 된다.
        //upmu[0] = 업무이름저장
        //upmu[1] = 페이지 이름
        //배열은 복사가 안됨.
        String temp[] = null;
        temp = command.split("/");// temp[0]=pojo, temp[1]=board, temp[2]= boardList, or boardInsert , boardUpdate, boardDelete
        String upmu[] = new String[temp.length-1];//2개 upmu[0]=temp[1], upmu[1]= temp[2]
        //업무배열을 생성시에 temp에 담긴 pojo는 제외시킨다.
        System.arraycopy(temp, 1, upmu, 0, temp.length-1);
        //결과는 temp[0]에 있던 pojo는 제외되었다.
        log.info(upmu.length);//2가 된다.왜냐면 temp에서 pojo제외시킴 upmu[0]= board, upmu[1]=boardList - .do제외되었다.
        //실제 기능을 구현하는 클래스는 BoardController이므로 요청객체에 정보를 담아 둔다.
        //req는 저장소역할 - 배열의 주소번지 저장. BoardController에서 사용할 수 있다.
        req.setAttribute("upmu", upmu);//결과적으로 얕은복사됨
        //웹서비스에 필요한 request와 response객체는 ActionServlet으로 부터 주입 받는다.
        BoardController boardController = new BoardController();
        try{
          boardController.execute(req, res);
        }catch(Exception e){
          e.printStackTrace();
        }
        //upmu[1] -> OrderController, BoardController, NoticeController, MemberController
        //upmu[2] -> boardList.ko.jsp -> ko는 빼고 .jsp붙여야 하므로 배열에 담을 때 ko는 제거 할것.
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doDelete");
        doService(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet");
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doPost");
        doService(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doPut");
        doService(req, resp);
    }    
}