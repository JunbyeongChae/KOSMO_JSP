<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>웹서버에서 쿠키 생성하기</title>
</head>
<body>
    <h1>쿠키 생성</h1>
<%
    Cookie c1 = new Cookie("notebook", "삼성갤럭시N9");
    //만일 시간을 부여하지 않으면 브라우저가 종료될 때 자동으로 삭제됨
    c1.setMaxAge(60);
    Cookie c2 = new Cookie("hp", "아이폰16");
    //만일 시간을 부여하지 않으면 브라우저가 종료될 때 자동으로 삭제됨
    c2.setMaxAge(60*2);
    Cookie c3 = new Cookie("mouse", "로지텍마우스");
    //만일 시간을 부여하지 않으면 브라우저가 종료될 때 자동으로 삭제됨
    c3.setMaxAge(60*60);
    //쿠키는 path설정에 따라 값을 유지하기도 하고 못하기도 한다.
    //현재 내가 바라보는 프로젝트의 모든 path에서 접근하고 싶다면 반드시 루트패스로 설정할것. - 주의
    c3.setPath("/"); //c3쿠키는 path값을 루트로 함.
    //쿠키는 로컬 PC에 저장된다.
    //쿠키는 문자열만 저장된다.
    //쿠키는 클라이언트측으로 데이터를 내려야 한다.
    //새로운 쿠키를 생성하면 브라우저에 전송함.
    response.addCookie(c1);
    response.addCookie(c2);
    response.addCookie(c3);
%>
</body>
</html>