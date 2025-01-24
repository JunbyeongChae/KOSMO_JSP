<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    Cookie cs[] = request.getCookies();
    String cemail = null;
    if(cs !=null){
        for(int i=0;i<cs.length;i++){
            if("email".equals(cs[i].getName())){
                cemail = cs[i].getValue();
            }
        }//end of for
    }else{
        cemail = "쿠키값 없음.";
    }
    out.print(cemail);
    if(cemail == null){//로그인을 하지 않았다면 로그인 페이지로 이동하기 처리
        response.sendRedirect("./mycookie/loginFormGet.jsp");
    }else{
        out.print("쿠키값이 존재하면....");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Heading</h1>
    <p>Content</p>
</body>
</html>