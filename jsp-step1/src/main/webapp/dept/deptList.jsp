<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.vo.DeptVO" %>
<%
  DeptVO dvo = null;
  dvo = (DeptVO)request.getAttribute("dvo");
  request.setAttribute("dvo", dvo);
%>

<!DOCTYPE html>
<html>
<head>
    <title>deptList</title>
</head>
<body>
    <h1>deptList.</h1>
    <p><%= dvo.getDeptno() %>, <%= dvo.getDname() %>, <%= dvo.getLoc() %></p>
</body>
</html>