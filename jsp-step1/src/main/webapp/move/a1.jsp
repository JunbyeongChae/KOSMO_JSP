<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>forward</title>
</head>
<body>
    <h1>Heading</h1>
<%
    RequestDispatcher view = request.getRequestDispatcher("b1.jsp");
    view.forward(request, response);
%>
    <p>Content</p>
</body>
</html>