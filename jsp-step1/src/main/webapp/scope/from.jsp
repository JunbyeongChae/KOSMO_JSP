<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.vo.DeptVO" %>
<% 
  DeptVO dvo = new DeptVO();
  dvo.setDeptno(10); // 메서드 호출 방식으로 수정
  dvo.setDname("총무부");
  dvo.setLoc("대전");
  
  request.setAttribute("dvo", dvo);
%>

<!DOCTYPE html>
<html>
<head>
    <title>from.jsp</title>
</head>
<body>
    <h1>from.jsp페이지</h1>
    <p>Content</p>
    <jsp:forward page="to.jsp"/>
</body>
</html>