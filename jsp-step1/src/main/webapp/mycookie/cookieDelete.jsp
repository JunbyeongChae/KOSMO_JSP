<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>쿠키삭제</title>
</head>
<body>
  <%
    Cookie c1 = new Cookie("mouse", "");
    c1.setMaxAge(0);
    c1.setPath("/");
    response.addCookie(c1);
  %>
</body>
</html>