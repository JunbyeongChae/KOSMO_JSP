<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>쿠키정보 읽어오기</title>
</head>
<body>
<%
    Cookie cs[] = request.getCookies();
    //쿠키에 값이 있는지 유무 체크하기 - 안전한 코드 - NullPointerException
    if(cs !=null && cs.length !=0){
        String c_name = null;
        for(int i=0;i<cs.length;i++){
            if("notebook".equals(cs[i].getName())){
                c_name = cs[i].getValue();
                out.print(c_name);
            }
            else if("hp".equals(cs[i].getName())){
                c_name = cs[i].getValue();
                out.print(c_name);
            }
            else if("mouse".equals(cs[i].getName())){
                c_name = cs[i].getValue();
                out.print(c_name);
            }
        }//end of for
    }//////end of if
%>
<button onclick="cookieDelete(event)">쿠키삭제</button>
<script>
    //웹에서는 이벤트에 버블링과 캡쳐링이 있다.
    const cookieDelete = (e) => {
        e.preventDefault() //이벤트가 전이되는 것을 막아 줌. - 새로고침 발생하는 이슈 방어함.
        //아래코드로 새로운 페이지를 요청하면 주소창이 바뀐다.
        //이것은 기존에 요청은 끊어지고 새로운 요청이 일어났다. -http- stateless
        window.location.href = "cookieDelete.jsp"
    }
</script>
</body>
</html>