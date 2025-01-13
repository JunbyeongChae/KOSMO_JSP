<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.demo.vo.DeptVO" %>
<%
    //스크립틀릿
    //jsp페이지에서 내장객체를 사용할 때는 전체 이름을 다 적습니다.
    //줄임말 안됨.
    DeptVO dvo = (DeptVO)request.getAttribute("dvo");
%>
<!DOCTYPE html>
<html>
<head>
    <title>부서관리</title>
</head>
<body>
    <h1>부서목록 페이지</h1>
    <h2><%=dvo.getDeptno()%></h2>
    <h3><%=dvo.getDname()%></h3>
    <h4><%=dvo.getLoc()%></h4>
</body>
</html>