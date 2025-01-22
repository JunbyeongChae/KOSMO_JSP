<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>POST로그인</title>
</head>
<body>
    <form id="f_login" action="/mycookie/login" method="post">
      <button onclick="loginAction()">POST</button>
    </form>
    <script>
      const loginAction = () => {
        const f_login = document.querySelector('#f_login');
        f_login.submit();
      }
    </script>
</body>
</html>