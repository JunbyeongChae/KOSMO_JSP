<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  Cookie cs[] = request.getCookies();
  String cid = null;
  if(cs !=null && cs.length !=0){
    for(int i=0;i<cs.length;i++){
      if("mem_nick".equals(cs[i].getName())){
        cid = cs[i].getValue();
      }
    }
  }else{
    cid = "쿠키값 없음.";
  }
  
  if(cid == null){
    response.sendRedirect("./mycookie/loginFormGet.jsp");
  }else{
    out.print("Hello "+cid);
  }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <div>
    <button>
      <a href="./mycookie/logout">로그아웃</a> 
    </button>
  </div>
</body>
</html>