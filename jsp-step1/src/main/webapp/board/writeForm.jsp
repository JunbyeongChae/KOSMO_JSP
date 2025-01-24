<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>글쓰기 화면</title>
</head>
<body>
    <!-- 
    요청 URL뒤에 *.do로 끝나는 요청에 대해서는 ActionServlet.java가 인터셉트 함.
    temp[] -> upmu[] -> pojo필요없으므로 제외
    -->
    <form method="get" action="/pojo/board/boardInsert.do">
        제목 : <input type="text" name="b_title" /><br />
        작성자 : <input type="text" name="b_writer" /><br />
        내용 : <input type="text" name="b_content" /><br />
        <button>저장</button>
    </form>
</body>
</html>