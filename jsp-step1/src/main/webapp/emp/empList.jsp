<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String name = null;
  name = (String)session.getAttribute("name");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome<%=name%></title>
</head>
<body>
    <h1>Heading</h1>
    <p><%=name%>, Welcome</p>
</body>
</html>