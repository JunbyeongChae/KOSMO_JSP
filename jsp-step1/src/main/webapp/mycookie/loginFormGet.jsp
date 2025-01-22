<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <title>GET로그인</title>
  </head>

  <body>
    <%
      Cookie cs[]=request.getCookies(); 
      String c_name = null; 
      if(cs != null && cs.length > 0){
        for(int i=0;i<cs.length;i++){ 
          if("mem_nick".equals(cs[i].getName())){
            c_name=cs[i].getValue();
            out.print(c_name);
            break;
          }
        }////// end of for
      }////// end of if

      if(c_name == null){ 
      %>
      <form action="/mycookie/login" method="get">
        <input type="text" name="mem_id" />
        <br />
        <input type="password" name="mem_pw" />
        <br />
        <button>로그인</button>
      </form>
    <% 
      }else{ 
        out.print("cs.length : "+cs.length);
    %>
        <form action="/mycookie/logout" method="get">
          <p><%= c_name %>님 환영합니다.</p>
          <button>로그아웃</button>
        </form>
    <% 
      }////////end of if 
    %>
  </body>
  </html>