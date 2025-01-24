<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인[Post방식]</title>
</head>
<body>
    <form id="f_login" method="post" action="/mycookie/login">
        <button onclick="loginAction()">로그인</button>
    </form>
    <script>
        const loginAction = () => {
            const f_login = document.querySelector("#f_login")
            f_login.submit()
        }
    </script>
</body>
</html>