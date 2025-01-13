<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.demo.vo.DeptVO" %>
<%
    //스크립틀릿 - 지변
    DeptVO dvo = null;
    dvo = (DeptVO)request.getAttribute("dvo");
%>
<!DOCTYPE html>
<html>
<head>
    <title>to.jsp</title>
</head>
<body>
    <h1>to.jsp페이지 입니다.</h1>
    <p><%= dvo.getDeptno() %>, <%= dvo.getDname() %>, <%= dvo.getLoc() %></p>
</body>
</html>