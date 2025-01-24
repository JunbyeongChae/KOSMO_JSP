<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인[Get방식]</title>
</head>
<body>
<%
    Cookie cs[] = request.getCookies();
    String c_name = null;
    //쿠키에 값이 있는지 유무 체크하기 - 안전한 코드 - NullPointerException
    if(cs !=null && cs.length >0){
        //쿠키정보가 여러가지 일 수 있어서 반복문 처리
        for(int i=0;i<cs.length;i++){
            if("nickname".equals(cs[i].getName())){
                c_name = cs[i].getValue();
                out.print("c_name : "+c_name);
            }
        }//end of for
    }//end of if - 쿠키값을 추출하기
    //쿠키값이 존재하니
    if(c_name == null){//쿠키에 저장된 값이 null이면 로그인을 하지 않은 사람
%>
    <form method="get" action="/mycookie/login">
<!-- 
        id사용할 때 - document.querySelector("#id") - 정적처리할 때 id를 사용함.
        name을 사용할 때 - request.getParameter("email") - 동적처리할 때 name을 사용함.
-->        
        <input type="text" name="email" />
        <br />
        <input type="text" name="mem_pw" />
        <button>로그인</button>
    </form>
<%
    }//end of if
    else{
        out.print("cs.length : "+cs.length);//JSESSIONID 항상 디폴트로 들어 있음.
%>
    <form method="get" action="/mycookie/logout">
        <%=c_name%>님 환영합니다.<br />
        <button>로그아웃</button>
    </form>
<%
    }//end of 쿠키에 값이 있을 때
%>
</body>
</html>