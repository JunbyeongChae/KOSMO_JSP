<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>쿠키삭제하기</title>
</head>
<body>
<%
    //스크립틀릿
    //req.setAttribute("",""), req.getAttribute("키"), req.removeAttribute("키")
    //쿠키를 삭제할때는 다른 API처럼 remove, deletet함수가 따로 제공되지 않는다.
    Cookie c1 = new Cookie("mouse","");//1시간
    c1.setMaxAge(0);
    c1.setPath("/");
    //주의사항 - 쿠키는 로컬에 관리되므로 생성(삭제) 후에는 반드시
    response.addCookie(c1);
%>
</body>
</html>
<!-- 
    테스트 시나리오
    1. 쿠키 생성 - cookieMake.jsp
    :쿠키로 로그인 구현하기
    2. 쿠키 읽기 - cookieRead.jsp
    :로그인 성공시 처리
    3.쿠키 삭제 - cookieDelete.jsp
    :로그아웃처리
    4. 검증 - 정말 삭제 된거야?
    : cookieRead.jsp
-->