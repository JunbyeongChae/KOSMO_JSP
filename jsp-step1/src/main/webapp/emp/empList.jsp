<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String name = null;//지역변수
    //getAttribute()리턴타입은 Object입니다.
    name = (String)session.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
    <title><%=name%>님 환영합니다.</title>
</head>
<body>
    <h1>Heading</h1>
    <p>세션값 : <%=name%>님 환영합니다.</p>
</body>
</html>