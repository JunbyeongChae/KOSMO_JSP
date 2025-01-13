<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.vo.DeptVO" %>
<%
    //스크립틀릿. - 자바코드 작성할 수 있다.
    DeptVO dvo = new DeptVO();
    dvo.setDeptno(10);
    dvo.setDname("총무부");
    dvo.setLoc("대전");
    //from.jsp에서 생성한 객체를 to.jsp에서 사용이 가능하다.
    request.setAttribute("dvo", dvo);
%>
<!-- 
클라이언트 사이드 렌더링
서버의 물리적인(webapp) 위치에서 다운로드 받는다.
확장자가 jsp인 경우에는 서버단에 선처리가 되고 그 결과를 응답으로 내려 보낸다.
-->
<!DOCTYPE html>
<html>
    <head>
        <title>from.jsp</title>
    </head>
    <body>
        <h1>from.jsp페이지</h1>
        <p>Content</p>
        <jsp:forward page="to.jsp" />
    </body>
    </html>
<!--  -->
<!-- 
scope속성 중에서 request에 대해 알아보는 예제
1)from.jsp
2)to.jsp
실제 브라우저에서 요청하는 페이지는 1번이었다.
:주소창을 통해서만 확인이 가능하다.
:화면에 출력되는 내용은 더이상 from.jsp가 아니었다.
:실제 출력되는 페이지는 to.jsp 내용이었다.
:요청이 URL이 그대로 이면 요청은 계속 유지되고 있다 라고 WAS 판단함.
:from.jsp에서 생성한 객체를 to.jsp에서도 사용이 가능하다.
:from.jsp 소스에서 jsp  액션태그인 forward를 만나면 그 페이지의 모든 내용은 볼 수가 없다.

jsp페이지에서 자바 코드를 사용할 수 있는 선언문
1)디클러레이션 : 메소드 선언, 전역변수

2)스크립틀릿 : 서블릿 라이프 사이클에서 service()에서 포함됨.
:스크립틀릿에서는 반드시 세미콜론을 찍는다.
제어문 사용 가능
변수 선언 및 초기화 가능함

init() -> service() -> destropy() 
메소드 안에서 선언하는 변수는 모두 지변이다.
메소드 선언이 불가함.
자바에서는 메소드 안에 메소드 선언이 불가함.
자바스크립트에서는 가능하다. - 일급함수, 고차함수, 일급객체 -> 트위터 -> 리덕스 -> Flux아키텍쳐(One way binding)
3)익스프레션 - 출력문이다. -> System.out.println()

주의사항은 println()괄호안에 세미콜론을 찍으면 안됨
-->