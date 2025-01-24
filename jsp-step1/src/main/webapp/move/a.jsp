<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Heading</h1>
<%
    //디클러레이션, 스크립틀릿, 익스프레션 
    //여기는 스크립틀릿 영역이다.
    response.sendRedirect("b.jsp");
    //위 방법으로 페이지를 이동하면 기존에 요청이 끊어지고 새로운 요청이 일어나 처리된다.
    //테스트 시나리오는 어떻게 되나요?
    // http://localhost:8000/move/a.jsp 엔터함. - > 요청이 일어남
    //서버측에서 webapp아래 move폴더에 있는 a.jsp찾아서 클라이언트에게 처리 후 그 결과 다운로드 시킴
    //쭉 읽다가 중간에 sendRedirect를 만나면 b.jsp페이지를 요청한다.
%>
    <p>Content</p>
</body>
</html>