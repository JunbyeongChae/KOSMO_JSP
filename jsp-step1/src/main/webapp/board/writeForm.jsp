<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>글쓰기</title>
</head>
<body>
<!-- 
  .do요청은 ActionServlet.java가 인터셉트
  temp[] -> upmu[] -> pojo필요없으므로 제외
-->
    <form action="pojo.board/boardInsert.do" method="get">
      제목: <input type="text" name="b_title" placeholder="제목"><br>
      작성자 :<input type="text" name="b_writer" placeholder="작성자"><br>
      내용 : <input type="text" name="b_content" placeholder="내용"><br>
      <button>저장</button>
    </form>
</body>
</html>